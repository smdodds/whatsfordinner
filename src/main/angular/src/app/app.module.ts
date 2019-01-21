import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginformComponent } from './core/loginform/loginform.component';
import { LoginService } from './shared/services/login.service';

import { HttpClientModule } from '@angular/common/http';
import { NavComponent } from './core/nav/nav.component';
import { HomeComponent } from './home/home.component';
import { FullRecipeComponent } from './recipe/full-recipe/full-recipe.component';
import { CreateprofileComponent } from './createprofile/createprofile.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginformComponent,
    NavComponent,
    HomeComponent,
    FullRecipeComponent,
    CreateprofileComponent,
    UpdateprofileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
