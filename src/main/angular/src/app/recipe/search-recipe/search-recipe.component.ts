import { Component, OnInit } from '@angular/core';
import { Recipe } from '../../shared/classes/recipe';
import { RecipeService } from '../../shared/services/recipe.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { IngredientService } from 'src/app/shared/services/ingredient.service';
import { Ingredient } from 'src/app/shared/classes/ingredient';

@Component({
  selector: 'app-search-recipe',
  templateUrl: './search-recipe.component.html',
  styleUrls: ['./search-recipe.component.css']
})
export class SearchRecipeComponent implements OnInit {
  private term: String;
  private tempTerm: any;
  ingredients: Array<Ingredient>;
  recipes: Array<Recipe>;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private recipeService: RecipeService,
    private ingredientService: IngredientService) {
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    };
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.term = params['term'];
      this.recipes = new Array<Recipe>();
      this.getIngredients();
      console.log(this.ingredients);
      if (this.term === ' ' || this.term === 'undefined' || this.term === 'null') {
        console.log("searching by ingredient");
        console.log(this.ingredients);
        this.searchByIngredient();
        console.log("recipes found");
        console.log(this.recipes);
      } else {
        console.log("search by term");
        this.searchByTerm();
      }
    });
  }
  ngOnChanges(){
    this.searchByIngredient();
  }
  navRecipe(id: number) {
    this.router.navigate(['/recipe/' + id]);
  }

  searchByTerm() {
    this.recipeService.searchRecipe(this.term).subscribe(recipe => {
      this.recipes = recipe;
    });
  }

  searchByIngredient() {
    this.recipeService.searchByIngredient(this.ingredients).subscribe(
      recipe => { this.recipes = recipe; });
  }

  getIngredients(){
    this.ingredientService.selectedIngredients.subscribe(ingredients =>
      this.ingredients = ingredients);
  }

}
