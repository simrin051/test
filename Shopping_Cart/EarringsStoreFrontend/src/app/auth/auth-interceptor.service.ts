import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Observable } from "rxjs";
import { TokenstorageService } from "./tokenstorage.service";

const TOKEN_HEADER_KEY="Authorization";

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor
{
   
    constructor(private token: TokenstorageService )
    {
            console.log("Inside AuthInterceptor");
    }

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        let authReq=req;
        const token=this.token.getToken();
        if(token!=null)
        {
            authReq=req.clone({headers: req.headers.set(TOKEN_HEADER_KEY,'Bearer'+token)})
        }
      return next.handle(authReq);
    }

}

