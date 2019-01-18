import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../shared/services/user.service';
import { User } from '../shared/classes/user';

@Component({
  selector: 'app-createprofile',
  templateUrl: './createprofile.component.html',
  styleUrls: ['./createprofile.component.css']
})
export class CreateprofileComponent{
  user = new User();
  verify = new User();
  emailVerify = true;
  unameVerify = true;
  cbox: boolean;

  constructor(private userService : UserService, private router: Router ) { 
    this.cbox = false;
  }

  ngOnInit() {
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
        this.userService.addUser(this.user).subscribe();
        this.router.navigate(['/login'])
      }
  }

  onCancel():void{
    console.log('onCancel');
    this.router.navigate(['/login'])
  }
}
