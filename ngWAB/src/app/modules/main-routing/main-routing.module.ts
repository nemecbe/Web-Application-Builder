import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from 'src/app/components/user/user.component';
import { LoginCompComponent } from 'src/app/components/login-comp/login-comp.component';
import { UserRegisterComponent } from 'src/app/components/user-register/user-register.component';
import { PageComponent } from 'src/app/components/page/page.component';
import { CompComponent } from 'src/app/components/comp/comp.component';
import { IndividualPageComponent } from 'src/app/components/individual-page/individual-page.component';
import { ExPage1Component } from 'src/app/components/ex-page1/ex-page1.component';

const routes: Routes = [
  { path: 'user/:uname', component: UserComponent },
  { path: 'login', component: LoginCompComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'register', component: UserRegisterComponent },
  { path: 'user/:uname/page', component: PageComponent},
  { path: 'user/:uname/page/:pId', component: IndividualPageComponent },
  // { path: 'page/:pagename', component: PublishedPageComponent },
  { path: 'page/example1', component: ExPage1Component }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class MainRoutingModule { }
