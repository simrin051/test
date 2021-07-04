import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { RouterModule } from '@angular/router';
import { AuthorizationComponent } from './authorization/authorization.component';
import { HeaderComponent } from '../header/header.component';

@NgModule({
  declarations: [
    AuthorizationComponent,
    
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    NgbModule, 
    FormsModule,
    ReactiveFormsModule,
    HomeRoutingModule

  ]
})
export class HomeModule { 
constructor()
{
  console.log("Home module loaded");
}

}
