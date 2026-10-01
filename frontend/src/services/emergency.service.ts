import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmergencyService {

  private apiUrl = 'http://localhost:8080/emergency';

  constructor(private http: HttpClient) {}

  findBestHospital(payload: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, payload);
  }
}
