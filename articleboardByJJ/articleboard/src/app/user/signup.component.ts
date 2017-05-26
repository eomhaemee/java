/**
 * Created by Admin on 2017-05-18.
 */
import {Component} from '@angular/core';
import {User} from "./user";
import {UserService} from "./user.service";
import {Router} from "@angular/router";


@Component({
  selector : 'signup',
  templateUrl : '../user/signup.component.html'
})

export class SignupComponent {

  user : User;
  constructor(private userService:UserService,private router:Router){ };

  signupUser(signupForm) {
    console.log("ㅎㅎㅎ");
    this.userService.signupUser(signupForm.form.value).subscribe(response=>{
      if(response){
        this.router.navigate(['/user/signin']);
      }
    })

  }

}
