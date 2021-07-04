import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Item } from './model/Item';
import { throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { CartItem } from './model/CartItem';
import { LoginRequest } from './auth/LoginRequest';
import { AuthService } from './auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  item: CartItem; 
  constructor(private http: HttpClient, private authservice: AuthService) {
   
   }
   handleError(error : any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
 }
 
   addToCart(item:Item )
   {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    
    const body=JSON.stringify(item);
    console.log("body "+body);
    const obj =JSON.parse(body);
    this.item = new CartItem(obj.name, obj.price,obj.url, obj.qty);
    return this.http.post<Item>("http://localhost:8080/add/cart",this.item,httpOptions).subscribe((data) => {
     console.log(data); 
  });

   }
   updatedItem(item : CartItem, updatedqty: String) :Observable<CartItem>
   {
    console.log("Inside updated item");
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    this.item = new CartItem(item.name, item.price,item.url, Number(updatedqty));
 return this.http.post<CartItem>("http://localhost:8080/item/cart",this.item, httpOptions);
   }
   getCartItems()
   {
   

    return this.http.get<CartItem>("http://localhost:8080/list/cart");
    
   }

   getModifiedListOfCartItems()
   {
    return this.http.get<CartItem>("http://localhost:8080/modifiedlist/cart");
   
   }
  removeItem(item: CartItem) :Observable<CartItem>
  {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    const restApiCall='http://localhost:8080/delete/'+item.name;
    console.log("Rest Api Call "+restApiCall);
    return this.http.post<CartItem>(restApiCall, httpOptions);
  }    
  
  placeorder(item: CartItem)
  {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    
    const body=JSON.stringify(item);
    console.log("body "+body);
    return this.http.post<CartItem>("http://localhost:8080/order",body,httpOptions).subscribe((data) => {
     console.log(data); 
  });
  }

  
}
