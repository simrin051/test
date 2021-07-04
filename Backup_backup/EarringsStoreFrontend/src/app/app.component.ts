import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { TokenstorageService } from './auth/tokenstorage.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  carouselimages : Array<string> =[];
  imagePath : any=null;
  authority : string;
  private roles: String[];
  constructor(config: NgbCarouselConfig, public tokenstorage: TokenstorageService) {  
    config.interval = 2000;  
    config.wrap = true;  
    config.keyboard = false;  
    config.pauseOnHover = false;  
  }  


ngOnInit(): void {
   
  this.imagePath='./assets/Carousel_images/Carousel1.jpg';
   this.carouselimages = ['./assets/Carousel_images/Carousel1.jpg',
   './assets/Carousel_images/Carousel2.jpg', './assets/Carousel_images/Carousel3.jpg','./assets/Carousel_images/Carousel4.jpg',
   './assets/Carousel_images/Carousel5.jpg'];  
   /** 
  if(this.tokenstorage.getToken())
  {
      this.roles=this.tokenstorage.getAuthorities();
      this.roles.every(role=>
        {
          if(role==='ROLE_ADMIN')
          {
            this.authority='admin';
            return false;
          
          }
          this.authority='user';
          return true;
        });
  }
**/
}

}
