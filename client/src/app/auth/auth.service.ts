import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SignInRequest } from './sign-in-request';
import { Observable } from 'rxjs';
import { JwtResponse } from './jwt-response';
import { SignUpRequest } from './sign-up-request';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private signinURL = 'http://localhost:8080/api/user/login';
  private signupURL = 'http://localhost:8080/api/user/register';

  constructor(private http: HttpClient) { }

  attemptAuth(credentials: SignInRequest): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.signinURL, credentials, httpOptions);
  }

  register(request: SignUpRequest): Observable<any> {
    return this.http.post<any>(this.signupURL, request, httpOptions);
  }

}
