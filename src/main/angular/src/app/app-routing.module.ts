import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginformComponent  } from './core/loginform/loginform.component';
import { HomeComponent} from './home/home.component'
<<<<<<< HEAD
import { CreateRecipeComponent } from './createrecipe/createrecipe.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginformComponent},  
  {path: 'createrecipe', component: CreateRecipeComponent}
=======
import { FridgeComponent } from './fridge/fridge.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginformComponent},
  {path: 'fridge', component: FridgeComponent}
>>>>>>> cca5d505791d6bfe68b2b942c97fe91cad25869c
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
