import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/types/user';
import { Router } from '@angular/router';
import { stringify } from '@angular/compiler/src/util';
import { UserComponent } from '../user/user.component';

@Component({
  selector: 'app-login-comp',
  templateUrl: './login-comp.component.html',
  styleUrls: ['./login-comp.component.css']
})
export class LoginCompComponent implements OnInit {

  user: User;
  auser: User  = {} as User;
  uName = '';
  pWord = '';
  loggedIn = false;

  constructor(private us: LoginServiceService, private router: Router) { }

  userLogin(): void {
    this.auser.uName = this.uName;
    this.auser.pWord = this.pWord;
    this.us.getUser(this.auser).subscribe(data => {
      this.user = data;
      if (this.user) {
        this.us.setUser(this.user);
        this.router.navigateByUrl('/user/' + this.user.uName);
      } else {
        this.router.navigateByUrl('/login');
        this.uName = '';
        this.pWord = '';
      }
    }
    );
  }

  ngOnInit() {
  }

}
