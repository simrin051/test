import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { LoginRequest } from './LoginRequest';
import { SignUpRequest } from '../model/SignUpRequest';
import { JwtResponse } from './JwtResponse';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  parsedJson: any;
  request: SignUpRequest;
  loginrequest: LoginRequest;
  resultdata: Object;
  curusername:string;
  count=0;
  private loginUrl: string="http://localhost:8080/api/login";
  private signUpUrl:string="http://localhost:8080/api/signup";
  constructor(private http: HttpClient) { }
  login(username:string, password:string ) {
    
    console.log(username+" up "+password);
    this.loginrequest= new LoginRequest( username,password);
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    console.log(this.loginUrl+" "+JSON.stringify(this.loginrequest));
    this.getCurrentUsername() ;
    return this.http.post<string>(this.loginUrl, this.loginrequest,httpOptions );
  }
    
   getCurrentUsername(): String
   {
    console.log("Current Username "+this.loginrequest.username);
    this.curusername=this.loginrequest.username;
    return this.curusername;
  }
 
  createAccount(form: NgForm): Observable<string>
    {
      this.parsedJson=JSON.parse(JSON.stringify(form.value));
      this.count=this.count+1;
      const httpOptions = {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
      }
     
      this.request = new SignUpRequest(this.parsedJson.userName, this.parsedJson.email, this.parsedJson.password, this.parsedJson.cpassword,this.parsedJson.tel);
      return this.http.post<string>(this.signUpUrl,this.request,httpOptions);
    }
            
}


