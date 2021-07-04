import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../model/Item';
import { SectionService } from '../section.service';

@Component({
  selector: 'app-neckpieces',
  templateUrl: './neckpieces.component.html',
  styleUrls: ['./neckpieces.component.scss']
})
export class NeckpiecesComponent implements OnInit {

  constructor( public sectionservice: SectionService,
    private route: ActivatedRoute,
    private router: Router) { }
  neckpieces: any;
  ngOnInit(): void {
    
    this.sectionservice.getNeckpieces().subscribe(data=>{
      console.log(data);
      this.neckpieces= data;
    })

  }
  onClick(neckpiece: Item) 
  {
    console.log("Inside onClick");
    let data= JSON.stringify(neckpiece);
    this.router.navigate(['/profile'], {queryParams: {'item': data}, skipLocationChange: true});
  // this.router.navigate(['/profile',neckpiece],{skipLocationChange: true});
   //this.router.navigate(['/some-url'], { queryParams:  JSON.stringify(neckpiece), skipLocationChange: true});  
   console.log(neckpiece.url); 


  }
  ;
}
