import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Exercise} from "../model/exercise";

@Injectable({
  providedIn: 'root'
})
export class ExercisesService {
  private baseUrl = '/api/exercise';

  constructor(private http: HttpClient) { }

  list(): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(this.baseUrl);
  }

}
