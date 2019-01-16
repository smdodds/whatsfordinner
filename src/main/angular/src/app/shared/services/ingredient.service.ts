import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import { Observable } from 'rxjs';
import { Ingredient } from '../classes/ingredient';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private url = this.urlSource.getURL() + '/ingredients';
  constructor(private urlSource: UrlService, private http: HttpClient) { }

  getAll(): Observable<Ingredient[]> {
    return this.http.get(this.url, {withCredentials: true}).pipe(map(resp => {
      return resp as Ingredient[];
    }))
  }
}
