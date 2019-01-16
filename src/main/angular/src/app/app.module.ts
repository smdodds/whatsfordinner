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
<<<<<<< HEAD
import { CreateRecipeComponent } from './createrecipe/createrecipe.component';
=======
import { FridgeService } from './shared/services/fridge.service';
import { FridgeComponent } from './fridge/fridge.component';
import { IngredientService } from './shared/services/ingredient.service';
>>>>>>> cca5d505791d6bfe68b2b942c97fe91cad25869c

@NgModule({
  declarations: [
    AppComponent,
    LoginformComponent,
    NavComponent,
    HomeComponent,
<<<<<<< HEAD
    CreateRecipeComponent
=======
    FridgeComponent
>>>>>>> cca5d505791d6bfe68b2b942c97fe91cad25869c
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
