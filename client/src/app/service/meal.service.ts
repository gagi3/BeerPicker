import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Meal } from '../model/meal';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MealService {
  private URL = 'http://localhost:8080/api/meal'

  constructor(private http: HttpClient) { }

  getAll(): Observable<Meal[]> {
    return this.http.get<Meal[]>(this.URL + '/', httpOptions);
  }

  getOne(id: number): Observable<Meal> {
    return this.http.get<Meal>(this.URL + '/' + id, httpOptions);
  }

  create(meal: Meal): Observable<Meal> {
    return this.http.post<Meal>(this.URL + '/create', meal, httpOptions);
  }

  update(meal: Meal): Observable<Meal> {
    return this.http.post<Meal>(this.URL + '/update', meal, httpOptions);
  }

  delete(id: number): Observable<boolean> {
    return this.http.get<boolean>(this.URL + '/delete/' + id, httpOptions);
  }
}
