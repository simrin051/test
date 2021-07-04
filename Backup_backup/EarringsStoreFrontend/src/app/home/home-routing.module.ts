import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { NavComponent } from '../nav/nav.component';
import { AuthorizationComponent } from './authorization/authorization.component';



const routes: Routes = [ 


  {path:'', component: AuthorizationComponent}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule, FormsModule,
    ReactiveFormsModule,]
})
export class HomeRoutingModule { }
