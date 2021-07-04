import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../model/Item';
import { SectionService } from '../section.service';

@Component({
  selector: 'app-bracelets',
  templateUrl: './bracelets.component.html',
  styleUrls: ['./bracelets.component.scss']
})
export class BraceletsComponent implements OnInit {

  constructor( public sectionservice: SectionService,private router: Router) { }
  bracelets: any;
  data:any;
  ngOnInit(): void {
    console.log("Inside bracelets component");
    this.sectionservice.getBracelets().subscribe(data=>{
      console.log(data);
      this.bracelets= data;
    })
  }

  onClick(bracelet: Item)
{
 console.log(bracelet.id); 
 console.log(bracelet.name); 
 console.log(bracelet.url); 
 this.data= JSON.stringify(bracelet);
 this.router.navigate(['/profile'], {queryParams: {'item': this.data}, skipLocationChange: true});
}

}
