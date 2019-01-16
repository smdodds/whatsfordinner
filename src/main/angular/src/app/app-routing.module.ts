import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginformComponent  } from './core/loginform/loginform.component';
import { HomeComponent} from './home/home.component';
import { FullRecipeComponent} from './recipe/full-recipe/full-recipe.component';
import { CreateprofileComponent } from './createprofile/createprofile.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginformComponent},
  {path: 'recipe/:id', component: FullRecipeComponent},
  {path: 'createprofile', component: CreateprofileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
