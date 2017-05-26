
import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs/Observable";
import {User} from "./user";

@Injectable()
export class UserService {

  constructor(private http:Http) { };

  signupUser(user : User) : Observable<boolean> {

    const header = new Headers();
    header.append("Content-Type","application/x-www-form-urlencoded");

    return this.http.post("http://localhost:3000/user/signup",`id=${user.id}&password=${user.password}&name=${user.name}`,
      {headers:header}).map(response=><boolean>response.json().result);
  }
  signinUser(user: User) : Observable<any>{
    const header = new Headers();
    header.append("Content-Type","application/x-www-form-urlencoded");

    return this.http.post("http://localhost:3000/user/signin",`id=${user.id}&password=${user.password}`,
      {headers:header}).map(response=><any>response.json());
  }
}
