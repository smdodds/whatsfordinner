import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../shared/services/login.service';
import { RecipeService } from '../../shared/services/recipe.service';
import { Recipe } from'../../shared/classes/recipe';
import { Router } from '@angular/router';



@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  term:string;
  searchHelp:Array<Recipe>;
  constructor(
    private loginService : LoginService,
    private router: Router,
    private recipeService: RecipeService) { }

  ngOnInit() {
    this.loginService.login(null,null).subscribe();
  }

  navSearch(){
    console.log("searching");
    this.router.navigate(['search/'+this.term]);
  }

  search(){
    this.recipeService.searchRecipe(this.term).subscribe(recipe =>{
      this.searchHelp = recipe;
    });
    console.log(this.searchHelp)
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

}
