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
    private recipeService : RecipeService, 
    private commentService:CommentService,
    private route: ActivatedRoute,
    private router: Router,
    private login: LoginService) { }
  
  ngOnInit() {
    this.loggedin = this.login.isloggedIn();

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
}

addNewComment(){
  this.newComment.id = null;
  this.newComment.userId = this.login.getUser().id;
  this.newComment.recipeId = this.id;
  this.newComment.submissionDate = null;

  console.log(this.newComment);
  this.commentService.saveRecipeComment(this.newComment).subscribe();

  this.router.navigate(['/recipe/'+this.id ]);
  }

    getCommentUser(id:number):String{
      let commentUser:User;

      this.userService.getUserById(id).subscribe(resp => {
        commentUser=resp});
      return commentUser.username;
  }
}
//Commented by {{getCommentUser(comment.userId)}} on 