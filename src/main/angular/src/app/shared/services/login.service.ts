import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import {User} from '../classes/user'
import { UrlService } from './url.service';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
private url = this.urlSource.getURL() + '/users/login';
private headers = new HttpHeaders({'Content-Type': 'application/json'});
loggedUser : User;
loggedIn = false;
rejected = false;

  constructor(private urlSource: UrlService, private http: HttpClient) { }

  login(email: string, password: string): Observable<boolean>{
    if(email&&password){
      //login 
      const body =`{"email": "${email}","password": "${password}"}`;
      return this.http.post(this.url, body, {headers: this.headers, withCredentials:true})
      .pipe(map(resp =>{
        const u: User = resp as User;
        if(u){
          this.loggedIn = true;
          this.loggedUser = u;
          this.rejected = false;
          return this.loggedIn;
        }else{
          this.rejected = true;
          return false;
        }
      }));
    }else{
      //check if already logged in
      return this.http.post(this.url, {withCredentials: true}).pipe(
        map(resp =>{
          const u: User = resp as User;
          this.rejected = false;
          return this.loggedIn;
        })
      );
    }
  }

  logout(): Observable<Object> {
    return this.http.delete(this.url, { withCredentials: true }).pipe(
      map(success=> {
        this.loggedUser = null;
        this.loggedIn = false;
        this.rejected = false;
        return success;
      }));
  }

  getUser():User{
    return this.loggedUser;
  }

  isloggedIn():boolean{
    return this.loggedIn;
  }

  isRejected():boolean{
    return this.rejected;
  }
}
