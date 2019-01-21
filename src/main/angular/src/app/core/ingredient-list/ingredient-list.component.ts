import { Component, OnInit } from '@angular/core';
import { IngredientService } from '../../shared/services/ingredient.service';
import { Ingredient } from '../../shared/classes/ingredient';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent implements OnInit {
  ingredients: Ingredient[];
  ingredientList = new Array<Ingredient>();


  constructor(private ingredientService: IngredientService) { }

  ngOnInit() {
    this.ingredientService.getAll().subscribe(resp => {
      this.ingredients = resp;
    });
  }

  toggle() {
    var item = (<HTMLInputElement>event.target);
    var tempIngredient = new Ingredient();
    var info = item.id.split(":");
    tempIngredient.id = +info[0];
    tempIngredient.name = info[1];
    if (item.checked) {
      this.ingredientList.push(tempIngredient);
    } else {
        this.ingredientList.forEach( (item, index) => {
          if(item.id === tempIngredient.id) this.ingredientList.splice(index,1);
        });
    }
    this.ingredientService.changeselected(this.ingredientList);
    console.log(this.ingredientList);
  }

}
