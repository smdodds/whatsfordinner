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
private headers = new HttpHeaders({'Content-Type': 'application/json'});
user : User;

  constructor(private urlSource: UrlService, private http: HttpClient) { }


  addUser(u: User): Observable<User> {
    return this.http.post(this.url, JSON.stringify(u), {headers: this.headers}).pipe(
      map(resp =>{
        const u2: User = resp as User;
        return u2;
      })
    )
  }

  getUser(u: User): Observable<User> {
    return this.http.post(this.url, JSON.stringify(u), {headers: this.headers}).pipe(
        map(resp =>{
          const u2: User = resp as User;
          return u2;
        })
      )
  }


}
