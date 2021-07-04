import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { AuthService } from '../auth/auth.service';


@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.scss']
})
export class AuthenticateComponent implements OnInit {

  signupForm : FormGroup;
  parsedJson: any;
  isSignedUp: boolean;  isSignUpFailed: boolean; errorMessage: string;
  constructor(private fb:FormBuilder, public authservice: AuthService) { 
    this.signupForm =  new FormGroup({
      userName:new FormControl( '',[Validators.required]),
      email:new FormControl( 'Email',[Validators.required]),
      password: new FormControl('Password',[Validators.required]),
      cpassword:  new FormControl('Confirm Password',[Validators.required]),
      tel:   new FormControl('Telephone',[Validators.required])
  });
  }

  ngOnInit(): void {
  }
  CreateAccount(signupForm: any)
  {
    this.parsedJson=JSON.parse(JSON.stringify(signupForm.value));
    console.log(  this.parsedJson);
  
    this.authservice.createAccount(signupForm).subscribe(
      data =>
      {
        console.log(data);
        this.isSignedUp=true;
        this.isSignUpFailed=false;
      },
      error =>
      {
        console.log(error);
        this.errorMessage=error.error.message;
        this.isSignUpFailed=true;
      }
    )
  }
}
