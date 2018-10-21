import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LoginServiceService } from './services/login-service.service';
import { HttpClientModule } from '@angular/common/http';
import { MainRoutingModule } from './modules/main-routing/main-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginCompComponent } from './components/login-comp/login-comp.component';
import { UserComponent } from './components/user/user.component';
import { UserRegisterComponent } from './components/user-register/user-register.component';
import { PageComponent } from './components/page/page.component';
import { CompComponent } from './components/comp/comp.component';
import { DraggableModule } from './Directives/draggable.module';
import { ButtonComponent } from './components/button/button.component';
import { CompsComponent } from './components/comps/comps.component';
import { IndividualPageComponent } from './components/individual-page/individual-page.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DefCompNavbarComponent } from './components/def-comp-navbar/def-comp-navbar.component';
import { ExPage1Component } from './components/ex-page1/ex-page1.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginCompComponent,
    UserComponent,
    UserRegisterComponent,
    PageComponent,
    CompComponent,
    ButtonComponent,
    CompsComponent,
    IndividualPageComponent,
    NavbarComponent,
    DefCompNavbarComponent,
    ExPage1Component
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    MainRoutingModule,
    DraggableModule
  ],
  providers: [
    LoginServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
