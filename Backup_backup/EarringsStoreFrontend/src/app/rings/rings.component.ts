import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../model/Item';
import { SectionService } from '../section.service';

@Component({
  selector: 'app-rings',
  templateUrl: './rings.component.html',
  styleUrls: ['./rings.component.scss']
})
export class RingsComponent implements OnInit {

  constructor(public sectionservice: SectionService,private router: Router) { }
  rings: any;
  ngOnInit(): void {
  
    this.sectionservice.getRings().subscribe(data=>{
      console.log(data);
      this.rings= data;
    })

}
onClick(ring: Item)
{
 console.log(ring.id); 
 console.log(ring.name); 
 console.log(ring.url); 
 let data= JSON.stringify(ring);
 this.router.navigate(['/profile'], {queryParams: {'item': data}, skipLocationChange: true});
 
}

}
