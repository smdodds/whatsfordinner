import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/services/user.service';
import { Router } from '@angular/router';
import { User } from '../shared/classes/user';
import { LoginService } from '../shared/services/login.service';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {
  user: User;
  pass: String;
  verify = new User();
  emailVerify = true;
  unameVerify = true;
  cbox = false;
  passConfirm = false;
  passAlert = false;

  constructor(private loginService: LoginService, private userService: UserService, private router: Router) { }

  ngOnInit() {
    if(this.loginService.isloggedIn()){
      this.user = this.loginService.getUser();
    } else{
      this.router.navigate(['/login']);
    }
  }

  confirmPass():void{
    if(this.pass === this.user.password){
      this.passConfirm = true;
      this.passAlert = false;
    }
    else{
      this.passConfirm = false;
      this.passAlert = true;
    }
  }

  onPassSubmit():void{
    this.confirmPass();
  }

  emailVerification():void{
    console.log('emailVerification()')
    this.userService.getUserByEmail(this.user).subscribe(resp => {
      this.verify = resp;

      if(this.verify != null){
        if(this.user.email == this.verify.email){
          this.emailVerify = false;
        } else{
          this.emailVerify = true;
        }

      } else {
        this.emailVerify = true;
      }

      if(!this.emailVerify){
        this.user.email = '';
        this.cbox = false;
      }

    });
  }

  usernameVerification():void{
    console.log('usernameVerification()')
    this.userService.getUserByUsername(this.user).subscribe( resp => {
      this.verify = resp;

      if(this.verify != null){

        if(this.verify.username != null){
          this.unameVerify = false;
        } else {
          this.unameVerify = true;
        }

      } else{
        this.unameVerify = true;
      }

      if(!this.unameVerify){
        this.user.username = '';
        this.cbox = false;
      }

    });
  }

  onConditions():void{
    console.log('onConditions()')
    this.usernameVerification();
    this.emailVerification();
  }

  resetCheckbox():void{
    this.cbox = false;
  }

  onSubmit():void{
    console.log('onSubmit()');
      if(this.emailVerify && this.unameVerify){
        this.userService.updateUser(this.user).subscribe();
        this.router.navigate(['/home'])
      }
  }

  onUpdate():void{

  }

  onCancel():void{
    console.log('onCancel');
    this.router.navigate(['/home'])
  }

}
