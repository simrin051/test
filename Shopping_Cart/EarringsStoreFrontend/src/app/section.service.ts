import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './model/Item';
import { Section } from './model/Section';

@Injectable({
  providedIn: 'root'
})
export class SectionService {

  constructor(public http: HttpClient) { }

  getSections()
  {
   return  this.http.get<Section>("http://localhost:8080/sections")
    
  }
  getEarrings()
  {
    return this.http.get<Item>("http://localhost:8080/earrings");   
  }
  getRings()
  {
    return this.http.get<Item>("http://localhost:8080/rings");   
  }
  getNeckpieces()
  {
    return this.http.get<Item>("http://localhost:8080/neckpieces");   
  }
  getBracelets()
  {
    return this.http.get<Item>("http://localhost:8080/bracelets");   
  }
}
