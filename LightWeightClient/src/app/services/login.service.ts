import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl = '/api';

  constructor(private http: HttpClient) { }

  doLogin(loginData: any): Observable<any> {
    return this.http.post<any>(this.baseUrl + "/login", loginData);
  }
}
