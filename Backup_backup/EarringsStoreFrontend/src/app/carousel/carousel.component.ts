import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {
  carouselimages: Array<string> = [];
  imagePath: any = null;
  constructor(config: NgbCarouselConfig) {
    config.interval = 2000;
    config.keyboard = true;
    config.pauseOnHover = true;
  }


  ngOnInit(): void {

      console.log("Inside  Carousel Component");
    this.carouselimages = ['./assets/Carousel_images/BohoCollection.PNG',
      './assets/Carousel_images/CasualCollection.PNG', './assets/Carousel_images/TinyTrinket.PNG'];



  }

}
