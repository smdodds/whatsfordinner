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

  constructor(private userService : UserService, private router: Router ) { }

  ngOnInit() {
  }

  onSubmit():void{
    console.log('onSubmit()');
    this.userService.addUser(this.user).subscribe();
  }

  onCancel():void{
    console.log('onCancel');
    this.router.navigate(['/login'])
  }
}
