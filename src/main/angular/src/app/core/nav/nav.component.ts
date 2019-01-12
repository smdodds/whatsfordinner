import { Component, OnInit } from '@angular/core';
import { LoginService } from "../../shared/services/login.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  constructor(private loginService : LoginService) { }

  ngOnInit() { }

  isAuth():boolean{
    return this.loginService.isloggedIn();
  }

  getUserName(){
    return this.loginService.getUser().username;
  }

  logout():void{
    this.loginService.logout().subscribe();
  }

}
