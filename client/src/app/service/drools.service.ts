import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Food } from '../model/food';
import { Beer } from '../model/beer';
import { Dish } from '../model/dish';
import { Meal } from '../model/meal';
import { Rule } from '../model/rule';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DroolsService {
  private URL = 'http://localhost:8080/api/drools'

  constructor(private http: HttpClient) { }

  create(rule: Rule): Observable<string> {
    return this.http.post<string>(this.URL + '/create', rule, httpOptions);
  }

  recommendByMeal(meal: Meal): Observable<Beer[]> {
    return this.http.post<Beer[]>(this.URL + '/recommend-by-meal', meal, httpOptions);
  }
}
