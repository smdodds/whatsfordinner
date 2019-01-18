import { Component, OnInit } from '@angular/core';
import { Recipe } from'../../shared/classes/recipe';
import { RecipeService } from '../../shared/services/recipe.service';
import {  Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-search-recipe',
  templateUrl: './search-recipe.component.html',
  styleUrls: ['./search-recipe.component.css']
})
export class SearchRecipeComponent implements OnInit {
  private term:String;
  private tempTerm:any;
  recipes :Array<Recipe>;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private recipeService: RecipeService) { 
      this.router.routeReuseStrategy.shouldReuseRoute = function() {
        return false;
    };
    }

  ngOnInit() {
    this.tempTerm = this.route.params.subscribe(params => {
      this.term = params['term']; 
    });
    console.log(this.term);
    this.recipeService.searchRecipe(this.term).subscribe(recipe =>{
      this.recipes = recipe;
    }); 
  }

  navRecipe(id:number){
    this.router.navigate(['/recipe/'+id ]);
  }

}
