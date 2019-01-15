import { Component, OnInit } from '@angular/core';
import { RecipeService } from "../../shared/services/recipe.service";
import { Recipe } from 'src/app/shared/classes/recipe';

import { switchMap } from 'rxjs/operators';
import {  Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { stringify } from '@angular/compiler/src/util';


@Component({
  selector: 'app-full-recipe',
  templateUrl: './full-recipe.component.html',
  styleUrls: ['./full-recipe.component.css']
})
export class FullRecipeComponent implements OnInit {
  recipe : Recipe;
  tempid : any;
  id: number;
  constructor(
    private recipeService : RecipeService, 
    private route: ActivatedRoute, 
    private router: Router) { }
  
  ngOnInit() {
    this.tempid = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
   });
   this.recipeService.getRecipe(this.id).subscribe(resp => {
    this.recipe = resp
  });
  }

}
