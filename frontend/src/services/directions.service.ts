import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

export interface RoutePoint {
  latitude: number;
  longitude: number;
}

export interface RouteResult {
  distance: number;
  travelTime: number;
  points: RoutePoint[];
}

@Injectable({
  providedIn: 'root'
})
export class DirectionsService {

  private api =
    'http://localhost:8087/api/routing/route';

  constructor(
    private http: HttpClient
  ) {
  }

  getRoute(
    fromLatitude: number,
    fromLongitude: number,
    toLatitude: number,
    toLongitude: number
  ): Observable<RouteResult> {

    console.log('================================');
    console.log('ROUTING REQUEST');
    console.log('URL =', this.api);
    console.log('FROM LAT =', fromLatitude);
    console.log('FROM LON =', fromLongitude);
    console.log('TO LAT =', toLatitude);
    console.log('TO LON =', toLongitude);

    return this.http.get<RouteResult>(
      this.api,
      {
        params: {
          fromLatitude,
          fromLongitude,
          toLatitude,
          toLongitude
        }
      }
    ).pipe(
      tap({
        next: (response) => {

          console.log('================================');
          console.log('ROUTING RESPONSE');
          console.log(response);

          console.log(
            'DISTANCE =',
            response.distance
          );

          console.log(
            'TRAVEL TIME =',
            response.travelTime
          );

          console.log(
            'POINTS COUNT =',
            response.points?.length
          );
        },

        error: (err) => {

          console.log('================================');
          console.log('ROUTING ERROR');
          console.log(err);
        }
      })
    );
  }
}