import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GeocodingService {
  constructor(private http: HttpClient) {}

  search(address: string): Observable<any[]> {
    console.log('================================');
    console.log('GEOCODING SEARCH');
    console.log('ADDRESS =', address);

    const url =
      'https://nominatim.openstreetmap.org/search' +
      '?q=' +
      encodeURIComponent(address) +
      '&format=jsonv2' +
      '&limit=1';

    console.log('URL =', url);

    return this.http.get<any[]>(url);
  }
}
