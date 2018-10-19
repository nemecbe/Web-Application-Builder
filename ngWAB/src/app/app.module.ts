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

@NgModule({
  declarations: [
    AppComponent,
    LoginCompComponent,
    UserComponent,
    UserRegisterComponent,
    PageComponent,
    CompComponent
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
