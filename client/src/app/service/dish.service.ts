import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dish } from '../model/dish';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DishService {
  private URL = 'http://localhost:8080/api/dish'

  constructor(private http: HttpClient) { }

  getAll(): Observable<Dish[]> {
    return this.http.get<Dish[]>(this.URL, httpOptions);
  }

  getOne(id: number): Observable<Dish> {
    return this.http.get<Dish>(this.URL + '/' + id, httpOptions);
  }

  create(dish: Dish): Observable<Dish> {
    return this.http.post<Dish>(this.URL + '/create', dish, httpOptions);
  }

  update(dish: Dish): Observable<Dish> {
    return this.http.post<Dish>(this.URL + '/update', dish, httpOptions);
  }

  delete(id: number): Observable<boolean> {
    return this.http.get<boolean>(this.URL + '/delete/' + id, httpOptions);
  }
}
