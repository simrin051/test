import { Injectable } from '@angular/core';

const AUTHORITIES_KEY=[{"authority":"ROLE_ADMIN"}];
const TOKEN_KEY='AuthToken';
const USERNAME_KEY='AuthUsername';
@Injectable({
  providedIn: 'root'
})

export class TokenstorageService {
  private roles: Array<string>=[];

 
  constructor() { 
   
  }
  signOut()
  {

  }
  public saveToken(token: string)
  {
    
    localStorage.removeItem(TOKEN_KEY);   
    localStorage.setItem(TOKEN_KEY, token);
     
  }  
  public saveUsername(username: string)
  {
    localStorage.removeItem(USERNAME_KEY);
    localStorage.setItem(USERNAME_KEY,username);
  }      
public  getToken() : string
  {
   
    return localStorage.getItem(TOKEN_KEY)|| '';
   
  }
  /** 
  public saveAuthorities(authorities: string[])
  {
    localStorage.removeItem(AUTHORITIES_KEY.toString);
    localStorage.setItem(AUTHORITIES_KEY,AUTHORITIES_KEY);
  }
  public getAuthorities(): string[]
  {
    this.roles=[];
    if(localStorage.getItem(TOKEN_KEY))
    {
      AUTHORITIES_KEY
      .forEach(authority => {
        this.roles.push(authority.authority);
        
      });
    }
    return this.roles;
  }
  **/
}
