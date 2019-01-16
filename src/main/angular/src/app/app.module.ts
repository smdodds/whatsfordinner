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
import { FridgeService } from './shared/services/fridge.service';
import { FridgeComponent } from './fridge/fridge.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginformComponent,
    NavComponent,
    HomeComponent,
    FridgeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    LoginService,
    FridgeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
