import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

export interface Recommendation {
  hospitalId: number;
  hospitalName: string;
  specialtyId: number;
  distance: number;
  availableBeds: number;
}

@Injectable({
  providedIn: 'root',
})
export class HospitalService {

  private apiHospital = 'http://localhost:8085';
  private apiRecommendations = 'http://localhost:8088';

  private specialtiesApi =
    `${this.apiHospital}/specialties`;

  private recommendationsApi =
    `${this.apiRecommendations}/recommendations`;

  constructor(
    private http: HttpClient
  ) {
  }

  getAllSpecialties(): Observable<any[]> {

    console.log('================================');
    console.log('GET SPECIALTIES');
    console.log('URL =', this.specialtiesApi);

    return this.http.get<any[]>(this.specialtiesApi).pipe(
      tap({
        next: (response) => {
          console.log('SPECIALTIES RESPONSE');
          console.log(response);
        },
        error: (err) => {
          console.log('SPECIALTIES ERROR');
          console.log(err);
        }
      })
    );
  }

  getBestHospital(
    lat: number,
    lon: number,
    specialtyId: number
  ): Observable<Recommendation> {

    const payload = {
      patientLatitude: lat,
      patientLongitude: lon,
      specialtyId: specialtyId
    };

    console.log('================================');
    console.log('RECOMMENDATION REQUEST');
    console.log('URL =', this.recommendationsApi);
    console.log('PAYLOAD =', payload);

    return this.http.post<Recommendation>(
      this.recommendationsApi,
      payload
    ).pipe(
      tap({
        next: (response) => {
          console.log('================================');
          console.log('RECOMMENDATION RESPONSE');
          console.log(response);
        },
        error: (err) => {
          console.log('================================');
          console.log('RECOMMENDATION ERROR');
          console.log('STATUS =', err.status);
          console.log('STATUS TEXT =', err.statusText);
          console.log('ERROR =', err.error);
          console.log(err);
        }
      })
    );
  }

  findBestHospital(
    lat: number,
    lon: number,
    specialtyId: number
  ): Observable<Recommendation> {

    return this.getBestHospital(
      lat,
      lon,
      specialtyId
    );
  }

  getHospitalById(
    hospitalId: number
  ): Observable<any> {

    const url =
      `${this.apiHospital}/hospitals/${hospitalId}`;

    console.log('================================');
    console.log('GET HOSPITAL');
    console.log('URL =', url);

    return this.http.get<any>(url).pipe(
      tap({
        next: (response) => {
          console.log('================================');
          console.log('HOSPITAL RESPONSE');
          console.log(response);
        },
        error: (err) => {
          console.log('================================');
          console.log('HOSPITAL ERROR');
          console.log(err);
        }
      })
    );
  }
}