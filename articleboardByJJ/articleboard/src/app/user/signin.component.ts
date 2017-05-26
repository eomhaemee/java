/**
 * Created by Admin on 2017-05-18.
 */
import {Component} from '@angular/core';
import {User} from "./user";
import {UserService} from "./user.service";
import {Router} from "@angular/router";
import {UserConstant} from "./user.constant";

@Component({
  selector : 'signin',
  templateUrl : '../user/signin.component.html'
})

export class SigninComponent{

  user : User;
  constructor(private userService:UserService,private router:Router){ };

  signinUser(signinForm){

    this.userService.signinUser(signinForm.form.value).subscribe(response=>{
      if( response.error ){
        alert(response.error);
      }
      else if(response.result){
        console.log(response.user);
        UserConstant.user = response.user; // 서버로부터 전달받은 user정보를 상수에 (angular) 넣어준다.
        this.router.navigate(['']);
      }
      else {
        alert('아이디 혹은 비밀번호가 맞지 않습니다.');
      }
    })
  }

}
