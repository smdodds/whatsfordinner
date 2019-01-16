
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { IngredientService } from '../../shared/services/ingredient.service';
import{Recipe} from '../../shared/classes/recipe';
import{Ingredient} from '../../shared/classes/ingredient';

@Component({
  selector: 'app-createrecipe',
  templateUrl: './createrecipe.component.html',
  styleUrls: ['./createrecipe.component.css']
})
export class CreateRecipeComponent implements OnInit {

  constructor(
    private router: Router,
    private ingredients: Ingredient[],
    private ingredientService: IngredientService) { }
  
  ngOnInit() {
    this.ingredientService.getAll().subscribe(resp => {
      this.ingredients = resp})
  }

  getIngredients(){
  }

  submitRecipe():void{
  }
  
  cancelRecipe():void{
    this.router.navigate(['/login']);
  }
}
