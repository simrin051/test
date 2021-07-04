import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NavComponent } from './nav/nav.component';
import { MatIconRegistry } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { AuthorizationComponent } from './home/authorization/authorization.component';
import { RouterModule } from '@angular/router';
import {HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CarouselComponent } from './carousel/carousel.component';
import { HomeModule } from './home/home.module';
import { SectionsComponent } from './sections/sections.component';
import { RingsComponent } from './rings/rings.component';
import { NeckpiecesComponent } from './neckpieces/neckpieces.component';
import { BraceletsComponent } from './bracelets/bracelets.component';
import { EarringsComponent } from './earrings/earrings.component';
import { ProfileComponent } from './profile/profile.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FooterComponent } from './footer/footer.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { MarkAsteriskDirective } from './directives/mark-asterisk.directive';
import { AuthInterceptor } from './auth/auth-interceptor';
import { AuthInterceptorService } from './auth/auth-interceptor.service';
import { MyCartComponent } from './my-cart/my-cart.component';
@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    CarouselComponent,
    SectionsComponent,
    RingsComponent,
    NeckpiecesComponent,
    BraceletsComponent,
    EarringsComponent,
    ProfileComponent,
    HeaderComponent,
    FooterComponent,
    AuthenticateComponent,
    MarkAsteriskDirective,
    MyCartComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule,
    HomeModule,
    MatSelectModule, 
    BrowserAnimationsModule 
  ], 
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass:  AuthInterceptorService, multi: true },

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
