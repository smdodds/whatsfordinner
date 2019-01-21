import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import {User} from '../classes/user'
import { UrlService } from './url.service';


@Injectable({
  providedIn: 'root'
})
export class UserService {
private url = this.urlSource.getURL() + '/users';
private urlAdd = this.urlSource.getURL() + '/users/add';
private urlGet = this.urlSource.getURL() + '/users/get';
private urlGetByEmail = this.urlSource.getURL() + '/users/email';
private urlGetByUsername = this.urlSource.getURL() + '/users/username';
private headers = new HttpHeaders({'Content-Type': 'application/json'});
user : User;

  constructor(private urlSource: UrlService, private http: HttpClient) { }


  addUser(u: User): Observable<User> {
    return this.http.post(this.urlAdd, JSON.stringify(u), {headers: this.headers}).pipe(
      map(resp =>{
        const returnedUser: User = resp as User;
        return returnedUser;
      })
    )
  }

  getUser(u: User): Observable<User> {
    return this.http.post(this.urlGet, JSON.stringify(u), {headers: this.headers}).pipe(
        map(resp =>{
          const returnedUser: User = resp as User;
          return returnedUser;
        })
      )
  }

  getUserByEmail(u: User): Observable<User> {
    return this.http.post(this.urlGetByEmail, JSON.stringify(u), {headers: this.headers}).pipe(
        map(resp =>{
          const returnedUser: User = resp as User;
          return returnedUser;
        })
      )
  }

  getUserByUsername(u: User): Observable<User> {
    return this.http.post(this.urlGetByUsername, JSON.stringify(u), {headers: this.headers}).pipe(
        map(resp =>{
          const returnedUser: User = resp as User;
          return returnedUser;
        })
      )
  }

  updateUser(u: User): Observable<User> {
    return this.http.put(this.url, JSON.stringify(u), {headers: this.headers}).pipe(
      map(resp =>{
        const returnedUser: User = resp as User;
        return returnedUser;
      })
    )
  }

}
