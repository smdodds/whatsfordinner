import { Component, OnInit } from '@angular/core';
import { LoginService } from "../../shared/services/login.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  constructor(private loginService : LoginService,private router: Router) { }

  ngOnInit() {
    this.loginService.login(null,null).subscribe();
  }

  isAuth():boolean{
    return this.loginService.isloggedIn();
  }

  getUserName(){
    return this.loginService.getUser().username;
  }

  logout():void{
    this.loginService.logout().subscribe();
    this.router.navigate(['/login'])
  }

  goLogin():void{
    this.router.navigate(['/login']);
  }

  updateProfile():void{
    this.router.navigate(['/updateprofile']);
  }

}
