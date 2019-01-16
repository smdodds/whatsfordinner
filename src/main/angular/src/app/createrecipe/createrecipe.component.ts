
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from '../shared/services/url.service';
import{Recipe} from '../shared/classes/recipe';
import{Ingredient} from '../shared/classes/ingredient';

@Component({
  selector: 'app-createrecipe',
  templateUrl: './createrecipe.component.html',
  styleUrls: ['./createrecipe.component.css']
})
export class CreateRecipeComponent implements OnInit {

  constructor(private urlSource: UrlService,private router: Router,private http:HttpClient) { }
  
  private recipeurl = this.urlSource.getURL() + '/recipe';
  private ingredienturl = this.urlSource.getURL() + '/ingredients';
  
  private id: number = null;
  private name: String = '';
  private description: String = '';

  private test :Ingredient[];

  ngOnInit() {
  }

  getIngredients(){
  }

  submitRecipe():void{
  }
  
  cancelRecipe():void{
    this.router.navigate(['/login']);
  }
}
