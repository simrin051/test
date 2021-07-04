import { Component, OnInit } from '@angular/core';
import { SectionService } from '../section.service';
import { Item } from '../model/Item';
import { Router } from '@angular/router';
@Component({
  selector: 'app-earrings',
  templateUrl: './earrings.component.html',
  styleUrls: ['./earrings.component.scss']
})
export class EarringsComponent implements OnInit {
  earrings: any;
  neckpieces: any;
  data:any;
  constructor(public sectionservice : SectionService,private router: Router) { }

  ngOnInit(): void {
    console.log("Inside earrings component");
    this.sectionservice.getEarrings().subscribe(data=>{
      console.log(data);
      this.earrings= data;
    })
  }
  onClick(earring: Item)
  {
   console.log(earring.id); 
   console.log(earring.name); 
   console.log(earring.url); 
   this.data=JSON.stringify(earring);
   this.router.navigate(['/profile'], {queryParams: {'item': this.data}, skipLocationChange: true});
  }


}
