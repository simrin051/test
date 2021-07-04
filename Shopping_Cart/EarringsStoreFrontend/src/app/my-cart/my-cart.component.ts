import { formatNumber } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { sample, windowWhen } from 'rxjs/operators';
import { CartService } from '../cart.service';
import { CartItem } from '../model/CartItem';
import { Item } from '../model/Item';

@Component({
  selector: 'app-my-cart',
  templateUrl: './my-cart.component.html',
  styleUrls: ['./my-cart.component.scss']
})
export class MyCartComponent implements OnInit {

  constructor(public  cartservice: CartService,public route: Router  ) { }
  cartitems: any=null;
  Subtotal: any=0;
  updatedqty: number;
  Ordertotal: any=0;
  prevdate: Date;
  nextdate: Date;
  Qty: any;
  qty1: string;
  qty2: string;
  quantaties=[1,2,3,4,5];
  isSelected=true;
  ngOnInit(): void {
    this.listcartItems();
    
    }
    removeItem(item: CartItem )
    {
    
      console.log("Remove Item" +item.name);
      this.cartservice.removeItem(item).subscribe(data=>
        {
         console.log("Item is deleted") ;  
        });  // Note delete method does not return anything
      this.cartitems= this.modifiedListCartItems();
      console.log("Modified list of cart items "+this.cartitems);
    }
    updatedQty(e : any, item : CartItem)
    {
       item.qty=Number(e.target.value);
     
       console.log(e.target.value);
        this.cartservice.updatedItem(item, e.target.value).subscribe(data=>{
          console.log("updated cart item");
        });
        this.calculateSubtotal();
    }
   
    listcartItems() : any
    {
      console.log("Inside list cart items");
      this.route.routerState.root.queryParams.subscribe(
        params => {
         // location.reload();
          this.cartitems = JSON.parse(params['cartdata']);
          console.log("This cart items " +this.cartitems);
          if(!this.cartitems )
          {
       ///     window.location.reload();
            console.log("The cart items is undefined or null");
            
           
          }
         
           console.log("Inside list cart items"+this.cartitems);
           console.log("Data length "+this.cartitems.length);
          console.log("List of cart items "+this.cartitems);
        
        });
       
        this.calculateSubtotal();
        this.prevdate = new Date();
        this.prevdate.setDate( this.prevdate.getDate() + 15 );
        
        this.nextdate = new Date();
        this.nextdate.setDate( this.prevdate.getDate() + 6 );
        return  this.cartitems;
    }
    placeorder(item: CartItem)
    {
      console.log("This place order");
      this.cartservice.placeorder(item);
    }
     
  calculateSubtotal()
  {
    this.Subtotal=0;
   console.log("This cart items inside calculate sub total "+this.cartitems.length); 
    for(let cartitem of this.cartitems){
      
  //   console.log("Cart item price "+Number.parseFloat(cartitem.price.substring(1)).toFixed(2)); 
     this.Subtotal= (parseFloat(cartitem.price.substring(1)) * cartitem.qty) +  parseFloat(this.Subtotal);
     console.log("This subtotal "+this.Subtotal+"price "+cartitem.price.substring(1)+"qty "+cartitem.qty);
     this.Subtotal=this.Subtotal+".00";
     this.Ordertotal=parseFloat(this.Subtotal)+parseFloat("60.00");
     this.Ordertotal=this.Ordertotal+".00";
   }

 
  } 
 
  modifiedListCartItems() : any
  {
    this.cartservice.getModifiedListOfCartItems().subscribe(data=>{
      this.cartitems=data;
    }) 
      this.calculateSubtotal();
    return this.cartitems;
  }
  compare(qty1: any,qty2: any)
  {
  
    if(qty1 === qty2)
    {
      return true;
    }
    else
    {
      return false;
    }
 
}
}
