import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Workout } from './../model/workout';

@Injectable({
  providedIn: 'root'
})
export class WorkoutServiceService {
  private baseUrl = 'http://localhost:3000/workouts';

  constructor(private http: HttpClient) { }

  list(): Observable<Workout[]> {
    return this.http.get<Workout[]>(this.baseUrl);
  }
}
