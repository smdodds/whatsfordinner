import { Component, OnInit } from '@angular/core';
import { LoginService } from "../../shared/services/login.service";

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {
  loggedIn: boolean;
  email: string;
  password: string;

  constructor(private loginService : LoginService) { }

  ngOnInit() {
    this.loginService.login(null,null).subscribe( user =>{
       this.loggedIn = user;
    })
  }
  login(): void{
    console.log('loggin in');
    this.loginService.login(this.email, this.password).subscribe(user =>{
       this.loggedIn = user;
    })
  }

}
