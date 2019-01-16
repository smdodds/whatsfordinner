import { Component, OnInit } from '@angular/core';
import { Fridge } from '../shared/classes/fridge';
import { FridgeService } from '../shared/services/fridge.service';
import { LoginService } from '../shared/services/login.service';
import { IngredientService } from '../shared/services/ingredient.service';
import { Ingredient } from '../shared/classes/ingredient';
import { FormGroup, FormBuilder, FormControl, FormArray } from '@angular/forms';

@Component({
  selector: 'app-fridge',
  templateUrl: './fridge.component.html',
  styleUrls: ['./fridge.component.css']
})
export class FridgeComponent implements OnInit {
  form: FormGroup;
  fridge: Fridge;
  ingredients: Ingredient[];
  constructor(
    private formBuilder: FormBuilder,
    private fridgeService: FridgeService,
    private ingredientService: IngredientService,
    private loginService: LoginService ) { }

  ngOnInit() {
     // get the user's fridge
     this.fridgeService.getByUserId(this.loginService.getUser().id).subscribe(resp => {
      this.fridge = resp;
      console.log(this.fridge);
    });

    // get all ingredients, print them to screen
    this.ingredientService.getAll().subscribe(resp => {
      this.ingredients = resp;

      // controller for ingredients array, so checked items can be tracked
      const controls = this.ingredients.map(c => new FormControl(false));
      this.form = this.formBuilder.group({
        ingredients: new FormArray(controls)
      });
    });
  }

  // submit updated fridge with selected ingredients
  submit() {
    const selectedIngredientIds = this.form.value.ingredients
      .map((v, i) => v ? this.ingredients[i] : null)
      .filter(v => v !== null);

    this.fridge.ingredients = selectedIngredientIds
    this.fridgeService.update(this.fridge).subscribe(resp => {
      this.fridge = resp;
    });
    console.log(this.fridge);
  }
}
