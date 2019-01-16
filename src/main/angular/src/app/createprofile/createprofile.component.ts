import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from './profile';

@Component({
  selector: 'app-createprofile',
  templateUrl: './createprofile.component.html',
  styleUrls: ['./createprofile.component.css']
})
export class CreateprofileComponent{

  profile = new Profile(0,'','','','','', false);

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSubmit():void{
    console.log(this.profile.firstname);
    console.log(this.profile.lastname);
    console.log(this.profile.username);
    console.log(this.profile.password);
    console.log(this.profile.email);
    console.log(this.profile.checkbox)
  }

  onCancel():void{
    console.log('cancel create profile clicked');
    this.router.navigate(['/login'])
  }
}
