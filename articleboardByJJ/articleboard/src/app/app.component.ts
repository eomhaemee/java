import { Component } from '@angular/core';
import {UserConstant} from "./user/user.constant";
import {User} from "./user/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';

  getUser(){
    return UserConstant.user;
  }
  logout(){
    return UserConstant.user = {
      _id : '',
      id : '',
      password : '',
      name : '',
    }
  }
}
