import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { UrlService } from './url.service';
import { Recipe } from '../classes/recipe'

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private url = this.urlSource.getURL() + '/recipes';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private urlSource: UrlService, private http: HttpClient) { }

  getRecipe(id : number):Observable<Recipe>{
    return this.http.get(this.url+'/' +id ,{withCredentials: true}).pipe(map(
      resp => { 
        const r:Recipe = resp as Recipe;
        return r;
       }))
  };
}
