import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import { Observable, BehaviorSubject } from 'rxjs';
import { Ingredient } from '../classes/ingredient';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private url = this.urlSource.getURL() + '/ingredients';
  private ingredientSource = new BehaviorSubject(new Array<Ingredient>());
  selectedIngredients = this.ingredientSource.asObservable();
  constructor(private urlSource: UrlService, private http: HttpClient) { }

  getAll(): Observable<Ingredient[]> {
    return this.http.get(this.url, {withCredentials: true}).pipe(map(resp => {
      return resp as Ingredient[];
    }))
  }

  changeselected(i:Ingredient[]){
    this.ingredientSource.next(i);
  }
}
