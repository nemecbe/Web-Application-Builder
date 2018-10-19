import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/types/user';
import { Router } from '@angular/router';
import { stringify } from '@angular/compiler/src/util';
import { UserComponent } from '../user/user.component';
import { element } from 'protractor';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { DraggableModule } from './Directives/draggable.module';
@Component({
  selector: 'app-login-comp',
  templateUrl: './login-comp.component.html',
  // template:,
  styleUrls: ['./login-comp.component.css']
})
export class LoginCompComponent implements OnInit {

  user: User;
  auser: User  = {} as User;
  uName = '';
  pWord = '';
  loggedIn = false;

  constructor(private ls: LoginServiceService, private router: Router, private sanitizer: DomSanitizer) {}

  userLogin(): void {
    this.auser.uName = this.uName;
    this.auser.pWord = this.pWord;
    this.ls.getUser(this.auser).subscribe(data => {
      this.user = data;
      if (this.user) {
        this.ls.setUser(this.user);
        this.router.navigateByUrl('/user/' + this.user.uName);
      } else {
        this.router.navigateByUrl('/login');
        this.uName = '';
        this.pWord = '';
      }
    }
    );
  }

  ngOnInit() { }
}
