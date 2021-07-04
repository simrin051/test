import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { httpFactory } from '@angular/http/src/http_module';
import { Router } from '@angular/router';
import { SectionService } from '../section.service';

@Component({
  selector: 'app-sections',
  templateUrl: './sections.component.html',
  styleUrls: ['./sections.component.scss']
})
export class SectionsComponent implements OnInit {

  sections: any;
  constructor(public  sectionservice: SectionService, public router: Router) {
    console.log("Inside sections constructor");
   }
  ngOnInit(): void {
      console.log("inside ngOnInit sections");
      this.sectionservice.getSections().subscribe(data=>{
        console.log(data);
        this.sections= data;
      })
  }

  sectionCheck(val: any)
  {
    if(val.srcElement.innerHTML==="Rings")
    {
      this.router.navigate(['/rings']);  
    }
    else if(val.srcElement.innerHTML==="Neckpieces")
    {
      this.router.navigate(['/neckpieces']); 
    }
    else if(val.srcElement.innerHTML==="Earrings")
    {
      this.router.navigate(['/earrings']); 
    }
    else
    {
      this.router.navigate(['/bracelets']); 
    }
    
  }

}
