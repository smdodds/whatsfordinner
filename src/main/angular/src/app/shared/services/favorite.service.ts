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
    return this.http.post(this.url, r, {headers: this.headers, withCredentials:true })
    .pipe(map(resp => {
      this.loginService.loggedUser = resp as User;
      this.favorited = true;
      return true; 
    }));
  }

  delete(r: Recipe): Observable<Boolean> {
    return this.http.delete(this.url + '/' + r.id, { withCredentials:true })
    .pipe(map(resp => {
      //this.loginService.loggedUser = resp as User;
      for(let i = 0; i < this.loginService.loggedUser.favorites.length; i++) {
        if(this.loginService.loggedUser.favorites[i].id == r.id) {
          console.log("removing " + this.loginService.loggedUser.favorites.splice(i, 1));
        }
      }
      this.favorited = false;
      return false; 
    }));
  }
}
