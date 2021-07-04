import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  cartdata: any;
  ifadmin: boolean=true;
  constructor(public cart : CartService, public router: Router) { }
 
  ngOnInit(): void {
    

  }
  shoppingCart()
  {
    console.log("Inside shopping cart");
    this.cart.getCartItems().subscribe(data=>{
      console.log(data);
      this.cartdata= data;

     // this.router.navigate(['/profile'], {queryParams: {'item': data}, skipLocationChange: true});
   
      console.log("This cart data "+this.cartdata);
      this.router.navigate(['/cart'], 
        { queryParams: { cartdata: JSON.stringify(this.cartdata) }, skipLocationChange: true});
    })
  }
}
