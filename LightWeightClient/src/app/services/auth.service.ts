import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {getXHRResponse} from "rxjs/internal/ajax/getXHRResponse";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = '/api';

  constructor(private http: HttpClient, private router: Router) {
  }

  doLogin(loginData: any) {
    this.http.post<any>(this.baseUrl + "/login", loginData).subscribe(response => {
      localStorage.setItem("access_token", response['jwt']);
      this.router.navigate(['/workouts']);
    })
  }

  isLoggedIn(): boolean {
    let authToken = localStorage.getItem('access_token');
    return authToken !== null ? true : false;
  }

  getToken(): string {
    if (this.isLoggedIn()) {
      return localStorage.getItem("access_token") as string;
    }

    return "";
  }

}
