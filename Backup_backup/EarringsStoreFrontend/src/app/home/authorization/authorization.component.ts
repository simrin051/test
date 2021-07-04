import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/auth.service';
import { HttpClient } from '@angular/common/http';
import { TokenstorageService } from 'src/app/auth/tokenstorage.service';
//import { User } from '../../user.model';
import { JwtResponse } from 'src/app/auth/JwtResponse';
@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.scss']
})
export class AuthorizationComponent implements OnInit {

  loginForm: FormGroup;
  val: any;
  data: any;
  isValid=true;
  jsonparseddata: any;
  strdata: any;
  createAccount: boolean ; isLoginFailed: boolean; roles:any ; errorMessage: string;

  username: string;
  password: string;
   isLoginIn: boolean;
  constructor(private fb:FormBuilder, 
               public authService: AuthService, 
               private router: Router, public http:HttpClient, private   tokenStorage:  TokenstorageService) {
      console.log("Inside auth comp");        
      this.loginForm = this.fb.group({
          username:new FormControl('',[Validators.required]),
          password:new FormControl( '',[Validators.required])
      });
    }

  ngOnInit(): void {
    console.log(this.loginForm);
   
  }
reloadPage()
{
  window.location.reload();
}
  login()
  {
    this.val = this.loginForm.value;
     this.authService.login(this.val.username,this.val.password).subscribe
     (data => 
      {
        this.strdata=JSON.stringify(data);
        console.log("Str data "+this.strdata);
        this.jsonparseddata =JSON.parse(this.strdata);
        console.log(" JSON parsed data "+this.jsonparseddata.result.token);
        this.tokenStorage.saveToken(this.jsonparseddata.result.token);
        this.tokenStorage.saveUsername( this.jsonparseddata .username);
        this.isLoginFailed=false;
        this.isLoginIn=true;
       
      },
      error =>
      {
        console.log(error);
        this.errorMessage=error.error.message;
        this.isLoginFailed=true;
      }
      
      );
     /**subscribe(
      data=>{
    //    this.tokenStorage.saveToken(data.token.token);
     //   this.tokenStorage.saveUsername(data.username);
      /**   this.tokenStorage.saveAuthorities(data.authorities);
      this.isLoginFailed=false;
      this.isLoginIn=true;
   /**   this.roles=this.tokenStorage.getAuthorities(); 
    },
    error =>
    {
      console.log(error);
      this.errorMessage=error.error.message;
      this.isLoginFailed=true;
    }
  );
  /** 
    console.log(this.loginForm.value);
    this.val = this.loginForm.value;
    console.log(this.val.username+" "+this.val.password);
    if (this.val.username && this.val.password) {
      console.log("val username "+this.val.username);
      console.log("val password "+this.val.password);
      this.authService.login(this.val.username,this.val.password);
      if(typeof(this.authService.resultdata)!=undefined)
      {
          this.isValid=false;
      }
      
    }
    **/
  
  }
 
  ShowCreateAccount()
  {
  this.createAccount=true;

  }
  createAccountshow()
  {
    console.log("Inside create Account Show");
    this.router.navigate(['/authenticate']); 
  }
}
