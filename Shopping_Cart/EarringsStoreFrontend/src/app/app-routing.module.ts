import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { BraceletsComponent } from './bracelets/bracelets.component';

import { EarringsComponent } from './earrings/earrings.component';
import { AuthorizationComponent } from './home/authorization/authorization.component';
import { MyCartComponent } from './my-cart/my-cart.component';
import { NavComponent } from './nav/nav.component';
import { NeckpiecesComponent } from './neckpieces/neckpieces.component';
import { ProfileComponent } from './profile/profile.component';
import { RingsComponent } from './rings/rings.component';

const routes: Routes = [
  {path:'', component: NavComponent}, 
  {path: 'neckpieces', component: NeckpiecesComponent},
  {path: 'earrings', component: EarringsComponent},
  {path: 'bracelets', component: BraceletsComponent},
  {path: 'cart', component: MyCartComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'rings', component: RingsComponent},
  {path: 'rings', component: RingsComponent},
  {path: 'authenticate', component:  AuthenticateComponent},
{path: 'app-authorization',loadChildren: () => import('src/app/home/home.module').then(m => m.HomeModule) }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
