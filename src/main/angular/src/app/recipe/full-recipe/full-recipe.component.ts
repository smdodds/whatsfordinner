import { Component, OnInit } from '@angular/core';
import { RecipeService } from "../../shared/services/recipe.service";
import { Recipe } from 'src/app/shared/classes/recipe';

import { switchMap } from 'rxjs/operators';
import {  Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { stringify } from '@angular/compiler/src/util';
import { FavoriteService } from 'src/app/shared/services/favorite.service';
import { LoginService } from 'src/app/shared/services/login.service';


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
    private loginService: LoginService,
    private recipeService: RecipeService, 
    private favoriteService: FavoriteService,
    private route: ActivatedRoute, 
    private router: Router) { }
  
  ngOnInit() {
    this.tempid = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
    });
    
    this.recipeService.getRecipe(this.id).subscribe(resp => {
      this.recipe = resp; 
    },
    () => this.containsRecipe()
    );
  }
  
  
  favorite() {
    this.favoriteService.update(this.recipe).subscribe(resp => {
      console.log(this.favoriteService.favorited);
    });
    
  }

  containsRecipe(): Boolean {
    console.log(this.loginService.loggedUser.favorites);
    for(let i = 0; i < this.loginService.loggedUser.favorites.length; i++) {
      if(this.loginService.loggedUser.favorites[i].id == this.recipe.id) {
        return true;
      }
    }
    return false;
  }
}
