import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { UrlService } from './url.service';
import { Comment } from '../classes/comment'

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private url = this.urlSource.getURL() + '/comment';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});  

  constructor(private urlSource: UrlService, private http: HttpClient) { }

  saveRecipeComment(c:Comment):Observable<Comment>{
    return this.http.post(this.url,c,{headers:this.headers,withCredentials:true}).pipe(map(
      resp=>{        
        const c:Comment = resp as Comment;
        return c;
      }
    ))
  }

  getRecipeComments(id:number):Observable<Array<Comment>>{
    return this.http.get(this.url+'/'+id, {withCredentials: true}).pipe(map(
      resp => { 
        const cArray:Array<Comment>= resp as Array<Comment>;
        return cArray;
       }));
  }
  
}
