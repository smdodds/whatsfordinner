import { Component, OnInit } from '@angular/core';
import { RecipeService } from "../../shared/services/recipe.service";
import { CommentService } from '../../shared/services/comment.service'
import { LoginService } from '../../shared/services/login.service';
import { UserService } from '../../shared/services/user.service';
import { Recipe } from '../../shared/classes/recipe';
import { Comment } from '../../shared/classes/comment';
import { User } from '../../shared/classes/user'

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
  newComment:Comment = new Comment;
  loggedin:Boolean;
  recipe : Recipe;
  comments:Array<Comment>;
  tempid : any;
  id: number;
  constructor(
    private userService : UserService,
    private loginService: LoginService,
    private recipeService : RecipeService, 
    private favoriteService: FavoriteService,
    private commentService: CommentService,
    private route: ActivatedRoute,
    private router: Router) { }

  
  ngOnInit() {
    this.loggedin = this.loginService.isloggedIn();

    this.tempid = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      });

      this.recipeService.getRecipe(this.id).subscribe(resp => {
        this.recipe = resp;
      });

      this.populateComments();
    }
  
populateComments(){  
  this.commentService.getRecipeComments(this.id).subscribe(resp => {
    this.comments = resp})

    });
    
    this.recipeService.getRecipe(this.id).subscribe(resp => {
      this.recipe = resp; 
    },
    // after getting the recipe, check if it's in the user's favorites
    () => this.containsRecipe()
    );
  }
  
  
  favorite() {
    if(this.containsRecipe()) {
      this.favoriteService.delete(this.recipe).subscribe(resp => {
      });
    } else {
      this.favoriteService.update(this.recipe).subscribe(resp => {
      });
    }    
  }

  containsRecipe(): Boolean {
    // check if the user's favorites contain the currently viewed recipe
    for(let i = 0; i < this.loginService.loggedUser.favorites.length; i++) {
      if(this.loginService.loggedUser.favorites[i].id == this.recipe.id) {
        return true;
      }
    }
    return false;
  }
}

addNewComment(){
  this.newComment.id = null;
  this.newComment.userId = this.loginService.getUser().id;
  this.newComment.recipeId = this.id;
  this.newComment.submissionDate = null;

  console.log(this.newComment);
  this.commentService.saveRecipeComment(this.newComment).subscribe();

  this.router.navigate(['/recipe/'+this.id ]);
  }
}