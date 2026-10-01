import { Component, AfterViewInit, OnInit, ChangeDetectorRef } from '@angular/core';
import * as L from 'leaflet';

import { CommonModule, NgIf, NgFor, DecimalPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { GeocodingService } from '../../services/geocoding.service';
import { HospitalService } from '../../services/hospital.service';
import { DirectionsService } from '../../services/directions.service';

@Component({
  selector: 'app-hospital-search',
  standalone: true,
  imports: [CommonModule, FormsModule, NgIf, NgFor, DecimalPipe],
  templateUrl: './hospital-search.html',
  styleUrls: ['./hospital-search.css'],
})
export class HospitalSearchComponent implements OnInit, AfterViewInit {
  map!: L.Map;

  userMarker?: L.Marker;
  hospitalMarker?: L.Marker;
  routeLine?: L.Polyline;

  address = '';

  specialty: number | null = null;
  specialties: any[] = [];

  error: string | null = null;
  result: any | null = null;

  constructor(
    private geocoding: GeocodingService,
    private hospitalService: HospitalService,
    private directions: DirectionsService,
    private cd: ChangeDetectorRef,
  ) {}

  ngOnInit(): void {
    this.hospitalService.getAllSpecialties().subscribe({
      next: (data) => {
        this.specialties = Array.isArray(data) ? data : [];

        this.cd.detectChanges();
      },

      error: () => {
        this.specialties = [];
        this.cd.detectChanges();
      },
    });
  }

  ngAfterViewInit(): void {
    this.map = L.map('map').setView([51.5074, -0.1278], 8);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '© OpenStreetMap',
    }).addTo(this.map);
  }

  searchAddress(): void {
    const query = this.address.trim();

    if (query.length < 3) {
      this.error = 'Please enter an address.';

      return;
    }

    this.error = null;

    this.geocoding.search(query).subscribe({
      next: (res) => {
        if (!res || res.length === 0) {
          this.error = 'Address not found.';

          return;
        }

        const bestMatch = res[0];

        const lat = parseFloat(bestMatch.lat);

        const lon = parseFloat(bestMatch.lon);

        this.setUserLocation(lat, lon);
      },

      error: () => {
        this.error = 'Unable to geocode address.';
      },
    });
  }

  selectSuggestion(s: any): void {
    this.address = s.display_name;

    const lat = parseFloat(s.lat);

    const lon = parseFloat(s.lon);

    this.setUserLocation(lat, lon);
  }

  useBrowserLocation(): void {
    if (!navigator.geolocation) {
      this.error = 'Geolocation not supported.';

      return;
    }

    navigator.geolocation.getCurrentPosition(
      (pos) => {
        const lat = pos.coords.latitude;

        const lon = pos.coords.longitude;

        this.setUserLocation(lat, lon);
      },

      () => {
        this.error = 'Unable to retrieve your location.';
      },
    );
  }

  setUserLocation(lat: number, lon: number): void {
    this.error = null;

    if (this.userMarker) {
      this.map.removeLayer(this.userMarker);
    }

    this.userMarker = L.marker([lat, lon]).addTo(this.map);

    this.map.setView([lat, lon], 14);
  }

  searchHospital(): void {
    if (!this.userMarker) {
      this.error = 'Please select an address or use your location.';

      return;
    }

    if (!this.specialty) {
      this.error = 'Please select a specialty.';

      return;
    }

    const { lat, lng } = this.userMarker.getLatLng();

    this.error = null;
    this.result = null;

    this.hospitalService.findBestHospital(lat, lng, this.specialty).subscribe({
      next: (recommendation) => {
        console.log('RECOMMENDATION RECEIVED', recommendation);

        this.result = recommendation;

        this.hospitalService.getHospitalById(recommendation.hospitalId).subscribe({
          next: (hospital) => {
            console.log('HOSPITAL RECEIVED', hospital);

            const hospLat = Number(hospital.latitude ?? hospital.lat);

            const hospLon = Number(hospital.longitude ?? hospital.lon);

            if (Number.isNaN(hospLat) || Number.isNaN(hospLon)) {
              this.error = 'Hospital coordinates are missing.';

              return;
            }

            if (this.hospitalMarker) {
              this.map.removeLayer(this.hospitalMarker);
            }

            this.hospitalMarker = L.marker([hospLat, hospLon]).addTo(this.map);

            this.directions.getRoute(lat, lng, hospLat, hospLon).subscribe({
              next: (response: any) => {
                console.log('ROUTE RECEIVED', response);

                const coords: L.LatLngExpression[] = response.points.map((p: any) => [
                  p.latitude,
                  p.longitude,
                ]);

                console.log('COORDS', coords);

                if (this.routeLine) {
                  this.map.removeLayer(this.routeLine);
                }

                this.routeLine = L.polyline(coords, {
                  color: 'blue',
                  weight: 4,
                }).addTo(this.map);

                this.map.fitBounds(this.routeLine.getBounds());

                this.result.distance = response.distance;

                this.result.travelTime = response.travelTime;

                this.cd.detectChanges();
              },

              error: (err) => {
                console.log('ROUTING ERROR', err);

                this.error = 'Unable to retrieve route.';
              },
            });
          },

          error: (err) => {
            console.log('HOSPITAL ERROR', err);

            this.error = 'Unable to retrieve hospital.';
          },
        });
      },

      error: (err) => {
        console.log('RECOMMENDATION ERROR', err);

        this.error = 'Unable to contact recommendation service.';
      },
    });
  }
}
