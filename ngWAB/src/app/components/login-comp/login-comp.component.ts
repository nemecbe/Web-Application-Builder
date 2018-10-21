import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/types/user';
import { Router } from '@angular/router';
import { stringify } from '@angular/compiler/src/util';
import { UserComponent } from '../user/user.component';
import { element } from 'protractor';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'app-login-comp',
  templateUrl: './login-comp.component.html',
  // template:,
  styleUrls: ['./login-comp.component.css']
})
export class LoginCompComponent implements OnInit {

  user: User;
  auser: User  = {} as User;
  text: string;
  uName = '';
  pWord = '';
  loggedIn = false;
  // element: string;
  // sh: SafeHtml;

  constructor(private ls: LoginServiceService, private router: Router, private sanitizer: DomSanitizer) {
    // this.element = '<button (click)="addElement()">Add Element</button>';
  }

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

  // addElement() {
  //   this.sh = this.sanitizer.bypassSecurityTrustHtml(this.element);
  //   this.element = this.element.concat('<div><h1>success</h1></div>');
  //   this.sh = this.sanitizer.bypassSecurityTrustHtml(this.element);
  // }
  // addLabel() {
  //   this.element = this.element.concat('<h1>success</h1>');
  //   this.sh = this.sanitizer.bypassSecurityTrustHtml(this.element);
  // }

  append() {
    // this.element = '<h1>change worked</h1>';
    // this.sh = this.sanitizer.bypassSecurityTrustHtml(this.element);
    this.text = 'something';
  }
}
