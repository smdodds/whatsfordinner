
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import{Recipe} from '../../shared/classes/recipe';
import{Ingredient} from '../../shared/classes/ingredient';

import { IngredientService } from '../../shared/services/ingredient.service';
import { RecipeService } from '../../shared/services/recipe.service'
import { LoginService } from '../../shared/services/login.service';

@Component({
  selector: 'app-createrecipe',
  templateUrl: './createrecipe.component.html',
  styleUrls: ['./createrecipe.component.css']
})
export class CreateRecipeComponent implements OnInit {
  
  private ingredients:Array<Ingredient>;  
  private newRecipe:Recipe;
  private name:string;
  private description:string;
  private recipeIngredients:Array<Ingredient> =[];

  constructor(
    private router: Router,
    private ingredientService: IngredientService,
    private login: LoginService,
    private recipeService: RecipeService) { }
  
  ngOnInit() { 

    if(this.login.loggedIn===false){
      this.router.navigate(['/home'])
    }

    this.ingredientService.getAll().subscribe(resp => {
      this.ingredients = resp})
  }
  submitRecipe(){
    this.newRecipe = new Recipe;
    this.newRecipe.id = null;
    this.newRecipe.name = this.name;
    this.newRecipe.description = this.description;
    this.newRecipe.ingredients = this.recipeIngredients;

    this.recipeService.saveRecipe(this.newRecipe).subscribe();

    console.log(JSON.stringify(this.newRecipe));

    this.router.navigate(['/home'])
  }

  addIngredient(i:number,b:boolean,id:number){

    if(b===true){
      this.recipeIngredients.push(this.ingredients[i]);
    }else{
      for (let count=0; count<this.recipeIngredients.length; count++) {
        if(this.recipeIngredients[count].id === id){
          this.recipeIngredients.splice(count,1);
        }
    }
  }
}
  cancelRecipe(){

    this.router.navigate(['/home'])
  }
}
