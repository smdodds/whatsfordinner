import { Component, OnInit } from '@angular/core';
import { LoginService } from "../../shared/services/login.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {
  loggedIn: boolean;
  email: string;
  password: string;

  constructor(private loginService : LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.login(null,null).subscribe( user =>{
       this.loggedIn = user;
    })
  }
  login(): void{
    console.log('loggin in');
    this.loginService.login(this.email, this.password).subscribe(log =>{
       this.loggedIn = log;
       console.log("log:"+log);
       if(this.loggedIn){
        console.log("going home")
        this.router.navigate(['/home']);
      }
    })
    
  }

  create(): void{
    console.log('create()');
    this.router.navigate(['/createprofile'])
  }

  isRejected():boolean{
    return this.loginService.isRejected();
  }

}
