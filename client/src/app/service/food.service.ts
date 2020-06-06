import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Food } from '../model/food';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  private URL = 'http://localhost:8080/api/food'

constructor(private http: HttpClient) { }

getAll(): Observable<Food[]> {
  return this.http.get<Food[]>(this.URL, httpOptions);
}

getOne(id: number): Observable<Food> {
  return this.http.get<Food>(this.URL + '/' + id, httpOptions);
}

create(food: Food): Observable<Food> {
  return this.http.post<Food>(this.URL + '/create', food, httpOptions);
}

update(food: Food): Observable<Food> {
  return this.http.post<Food>(this.URL + '/update', food, httpOptions);
}

delete(id: number): Observable<boolean> {
  return this.http.get<boolean>(this.URL + '/delete/' + id, httpOptions);
}
}
