import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Food } from '../model/food';
import { Beer } from '../model/beer';
import { Dish } from '../model/dish';
import { Meal } from '../model/meal';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DroolsService {
  private URL = 'http://localhost:8080/api/drools'

  constructor(private http: HttpClient) { }

  recommendByFood(food: Food): Observable<Beer[]> {
    return this.http.post<Beer[]>(this.URL + '/recommend-by-food', food, httpOptions);
  }

  recommendByDish(dish: Dish): Observable<Beer[]> {
    return this.http.post<Beer[]>(this.URL + '/recommend-by-dish', dish, httpOptions);
  }

  recommendByMeal(meal: Meal): Observable<Beer[]> {
    return this.http.post<Beer[]>(this.URL + '/recommend-by-meal', meal, httpOptions);
  }
}
