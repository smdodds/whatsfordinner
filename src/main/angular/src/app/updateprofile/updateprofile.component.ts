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
  user = new User();
  pass: String;
  formUser = new User();
  receivedUser: User;
  emailVerify = true;
  unameVerify = true;
  cbox = false;
  passConfirm = false;
  passAlert = false;

  constructor(private loginService: LoginService, private userService: UserService, private router: Router) { }

  ngOnInit() {
    if(this.loginService.isloggedIn()){
      this.user = this.loginService.getUser();
      this.formUser.email = this.user.email;
      this.formUser.username = this.user.username;
      this.formUser.firstname = this.user.firstname;
      this.formUser.lastname = this.user.lastname;
      this.formUser.password = this.user.password;
      this.formUser.id = this.user.id;
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
    if(this.user.email === this.formUser.email){
      this.emailVerify = true;
    } else {
      this.userService.getUserByEmail(this.formUser).subscribe(resp => {
        this.receivedUser = resp;

        if(this.receivedUser != null){
          if(this.receivedUser.email == this.formUser.email){
            this.emailVerify = false;
          } else{
            this.emailVerify = true;
          }

        } else {
          this.emailVerify = true;
        }

        if(!this.emailVerify){
          this.formUser.email = '';
          this.cbox = false;
        }

      });
    }
  }

  usernameVerification():void{
    if(this.user.username === this.formUser.username){
      this.unameVerify = true;
    } else{

      this.userService.getUserByUsername(this.formUser).subscribe( resp => {
        this.receivedUser = resp;

        if(this.receivedUser != null){

          if(this.formUser.username == this.receivedUser.username){
            this.unameVerify = false;
          } else {
            this.unameVerify = true;
          }

        } else{
          this.unameVerify = true;
        }

        if(!this.unameVerify){
          this.formUser.username = '';
          this.cbox = false;
        }

      });
    }
  }

  onConditions():void{
    this.usernameVerification();
    this.emailVerification();
  }

  resetCheckbox():void{
    this.cbox = false;
  }

  onUpdate():void{
      if(this.emailVerify && this.unameVerify){
        this.userService.updateUser(this.formUser).subscribe( resp =>{
          this.loginService.loggedUser = resp;
        });
        this.router.navigate(['/home'])
      }
  }

  onCancel():void{
    this.router.navigate(['/home'])
  }

}
