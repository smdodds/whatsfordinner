import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ingredient } from '../../shared/classes/ingredient';
import { Recipe } from '../../shared/classes/recipe';
import { IngredientService } from '../../shared/services/ingredient.service';
import { LoginService } from '../../shared/services/login.service';
import { RecipeService } from '../../shared/services/recipe.service';





@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  term:string;
  searchHelp:Array<Recipe>;
  ingredients:Ingredient[];
  constructor(
    private loginService : LoginService,
    private router: Router,
    private recipeService: RecipeService,
    private ingredientService:IngredientService) { }

  ngOnInit() {
    this.loginService.login(null,null).subscribe();
    
  }

  navSearch(){
    console.log("searching");
    this.router.navigate(['search/'+this.term]);
  }

  navSearchIngredient(){
    console.log("searching ingredients");
    this.router.navigate(['search/ ']);
  }

  search(){
    this.recipeService.searchRecipe(this.term).subscribe(recipe =>{
      this.searchHelp = recipe;
    });
  }
  newSearch(){
    this.ingredientService.changeselected(this.ingredients);
  }

  fill(term:string){
    this.term = term;
  }

  isAuth():boolean{
    return this.loginService.isloggedIn();
  }

  getUserName(){
    return this.loginService.getUser().username;
  }

  logout():void{
    this.loginService.logout().subscribe();
  }

  goLogin():void{
    this.router.navigate(['/login']);
  }

  goToFridge(): void {
    this.router.navigate(['/fridge']);
  }

  createRecipe(): void {
    this.router.navigate(['/createrecipe']);
  }

}
