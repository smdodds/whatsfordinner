import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginformComponent } from './core/loginform/loginform.component';
import { CreateRecipeComponent } from './recipe/createrecipe/createrecipe.component';
import { FullRecipeComponent } from './recipe/full-recipe/full-recipe.component';
import { FridgeComponent } from './fridge/fridge.component';
import { SearchRecipeComponent } from './recipe/search-recipe/search-recipe.component';

import { LoginService } from './shared/services/login.service';
import { FridgeService } from './shared/services/fridge.service';
import { IngredientService } from './shared/services/ingredient.service';

import { HttpClientModule } from '@angular/common/http';
import { NavComponent } from './core/nav/nav.component';
import { HomeComponent } from './home/home.component';
import { IngredientListComponent } from './core/ingredient-list/ingredient-list.component';

import { CreateprofileComponent } from './createprofile/createprofile.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';
import { FavoriteService } from './shared/services/favorite.service';
import { RecipeService } from './shared/services/recipe.service';
import { UrlService } from './shared/services/url.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginformComponent,
    NavComponent,
    HomeComponent,
    FullRecipeComponent,
    CreateprofileComponent,
    UpdateprofileComponent,
    SearchRecipeComponent,
    CreateRecipeComponent,
    FridgeComponent,
    IngredientListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    LoginService,
    FridgeService,
    IngredientService,
    RecipeService,
    UrlService,
    FavoriteService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }