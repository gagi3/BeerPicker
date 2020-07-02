import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Beer } from '../model/beer';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class BeerService {
  private URL = 'http://localhost:8080/api/beer'

  constructor(private http: HttpClient) { }

  getAll(): Observable<Beer[]> {
    return this.http.get<Beer[]>(this.URL + '/', httpOptions);
  }

  getOne(id: number): Observable<Beer> {
    return this.http.get<Beer>(this.URL + '/' + id, httpOptions);
  }

  create(beer: Beer): Observable<Beer> {
    return this.http.post<Beer>(this.URL + '/create', beer, httpOptions);
  }

  update(beer: Beer): Observable<Beer> {
    return this.http.post<Beer>(this.URL + '/update', beer, httpOptions);
  }

  delete(id: number): Observable<boolean> {
    return this.http.get<boolean>(this.URL + '/delete/' + id, httpOptions);
  }

}
