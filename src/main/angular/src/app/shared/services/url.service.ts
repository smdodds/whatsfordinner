import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {
  private static readonly URL = 'http://localhost:8080/whatsfordinner'
  constructor() { }
  public getURL(){
    return UrlService.URL;
  }
}
