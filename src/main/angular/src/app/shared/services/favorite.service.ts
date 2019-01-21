import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RecipeService } from './recipe.service';
import { Recipe } from '../classes/recipe';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { User } from '../classes/user';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class FavoriteService {
  favorited = false;
  private url = this.urlSource.getURL() + '/favorite';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(
    private urlSource: UrlService, 
    private recipeService: RecipeService,
    private loginService: LoginService,
    private http: HttpClient) { }

  update(r: Recipe): Observable<Boolean> {
    console.log(r);
    console.log(this.url);
    return this.http.post(this.url, r, {headers: this.headers, withCredentials:true})
    .pipe(map(resp => { 
      console.log(this.url);
      this.loginService.loggedUser = resp as User;
      this.favorited = true
      return true; 
    }));
  }
}
