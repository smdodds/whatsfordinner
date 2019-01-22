import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Recipe } from '../classes/recipe';
import { Ingredient } from '../../shared/classes/ingredient';
import { UrlService } from './url.service';



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
       }));
  }

  searchRecipe(term: String):Observable<Array<Recipe>>{
    return this.http.get(this.url+ '/search?term=' + term,{withCredentials: true}).pipe(map(
      resp =>{
        const rArray:Array<Recipe>= resp as Array<Recipe>;
        return rArray;
      }
    ));
  }
  
  searchByIngredient(i : Array<Ingredient>):Observable<Array<Recipe>>{
    return this.http.post(this.url+'/searchby', JSON.stringify(i), {headers: this.headers, withCredentials:true})
    .pipe(map(resp =>{
      const rArray:Array<Recipe>= resp as Array<Recipe>;
        return rArray;
    }))
  }
    
  saveRecipe(r: Recipe):Observable<Recipe>{
    return this.http.post(this.url,r,{headers: this.headers, withCredentials:true}).pipe(map(
      resp => {
        const r:Recipe = resp as Recipe;
        return r;
      }));
  }
}
