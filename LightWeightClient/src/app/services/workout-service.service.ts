import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Workout } from './../model/workout';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {
  private baseUrl = '/api/workout';

  constructor(private http: HttpClient) { }

  list(): Observable<Workout[]> {
    return this.http.get<Workout[]>(this.baseUrl);
  }

  getById(id: string | null): Observable<Workout> {
    return this.http.get<Workout>(this.baseUrl + "/" + id);
  }

  create(workout: Workout) {
    return this.http.post<Workout>(this.baseUrl, workout);
  }

  delete(id: number | undefined): Observable<Workout> {
    return this.http.delete<Workout>(this.baseUrl + "/" + id);
  }

  edit(workout: Workout) {
    return this.http.put<Workout>(this.baseUrl + "/" + workout.id, workout);
  }

}
