import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginformComponent } from './core/loginform/loginform.component';
import { LoginService } from './shared/services/login.service';

import { HttpClientModule } from '@angular/common/http';
import { NavComponent } from './core/nav/nav.component';
import { HomeComponent } from './home/home.component';

import { CreateRecipeComponent } from './createrecipe/createrecipe.component';

import { FridgeService } from './shared/services/fridge.service';
import { FridgeComponent } from './fridge/fridge.component';
import { IngredientService } from './shared/services/ingredient.service';

import { FullRecipeComponent } from './recipe/full-recipe/full-recipe.component';

import { SearchRecipeComponent } from './recipe/search-recipe/search-recipe.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginformComponent,
    NavComponent,
    HomeComponent,
    FullRecipeComponent,
    SearchRecipeComponent,
    CreateRecipeComponent,
    FridgeComponent
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
    IngredientService,
    FridgeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
