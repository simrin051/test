import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute, NavigationStart, NavigationEnd, Params } from '@angular/router';
import { filter } from 'rxjs/operators';
import { CartService } from '../cart.service';
import { CartItem } from '../model/CartItem';

import { Item } from '../model/Item';
import { NeckpiecesComponent } from '../neckpieces/neckpieces.component';
@Component({

  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  Qty: any='1';
 neckpiecedata: any;
 data:any;
 url:string; 
 sampledata:string;
 Neckpiece: Item;
 cartitem: CartItem; 
 selectedOption = '1';
 paramsObject: any;
 constructor(public activatedroute: ActivatedRoute,public router: Router,public cartService:CartService) {
/**
  const id = this.activatedroute.snapshot.params.id;
  this.data= JSON.parse(history.state.item);
 **/

  }
 
  ngOnInit(): void {
    this.activatedroute.queryParams.subscribe(
      params => {
          this.data = JSON.parse(params['item']);
       

      }
    )
    
  }

/**
  this.neckpiecedata=this.activatedroute.snapshot.paramMap.get('item');
   this.data= JSON.parse(this.neckpiecedata);
   this.url=this.data.url;
  console.log(this.data.name+" "+this.data.price+" "+this.data.url);
 */

AddToBag(item: Item)
{
  this.cartitem=Object.assign(item, { qty: this.Qty });
   console.log("Inside add to bag "+item.id+" "+item.name+" "+item.url+" "+this.Qty);
  this.cartService.addToCart(this.cartitem);
}

}
