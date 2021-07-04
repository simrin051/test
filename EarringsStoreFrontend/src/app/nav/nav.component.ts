import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  constructor( private route: ActivatedRoute,
    private router: Router ) { }

  ngOnInit(): void {
  }

  Login()
  {
    this.router.navigate(['/app-authorization']);
    console.log("I am inside login method");
  }

   getImage() {
    //Make a call to Sprinf Boot to get the Image Bytes.
    /**    this.httpClient.get('http://localhost:8080/image/get/' + this.imageName)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
       */

  }

}
