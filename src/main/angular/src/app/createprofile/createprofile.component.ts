import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createprofile',
  templateUrl: './createprofile.component.html',
  styleUrls: ['./createprofile.component.css']
})
export class CreateprofileComponent implements OnInit {
  firstname: string;
  lastname: string;
  username: string;
  password: string;
  email: string;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  createprofile():void{
    console.log(this.firstname);
    console.log(this.lastname);
    console.log(this.username);
    console.log(this.password);
    console.log(this.email);
  }

  cancel():void{
    console.log('cancel create profile clicked');
    this.router.navigate(['/login'])
  }
}
