import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginformComponent  } from './core/loginform/loginform.component';
import { HomeComponent} from './home/home.component'
import { FridgeComponent } from './fridge/fridge.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginformComponent},
  {path: 'fridge', component: FridgeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
