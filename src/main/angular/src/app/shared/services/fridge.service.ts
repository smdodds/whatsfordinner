import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Fridge } from '../classes/fridge';

@Injectable({
  providedIn: 'root'
})
export class FridgeService {
  fridge: Fridge;
  private url = this.urlSource.getURL() + '/fridge';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private urlSource: UrlService, private http: HttpClient) { }

  getByUserId(id: number): Observable<Fridge> {
    return this.http.get(this.url + '/' + id , {withCredentials: true})
    .pipe(map(resp => { 
        const f:Fridge = resp as Fridge;
        this.fridge = f;
        return this.fridge;
       }))
  }

  save(f: Fridge) {

  }

  update(f: Fridge): Observable<Fridge> {
    return this.http.put(this.url, JSON.stringify(f), {headers: this.headers, withCredentials:true})
    .pipe(map(resp => {
      this.fridge = resp as Fridge;
      return this.fridge;
    }))
  }

}
