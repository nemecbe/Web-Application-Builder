import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from '../../services/login-service.service';
import { PageService } from 'src/app/services/page.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private ls: LoginServiceService, private ps: PageService) { }

  ngOnInit() {
  }

  home() {
    this.router.navigateByUrl('user/' + this.ls.getCurrentUser().uName);
  }

  manage(): void {
    // console.log(this.user);
    const user = this.ls.getCurrentUser();
    this.ps.getPages(user).subscribe(data => {
      const pages = data;
      if (pages) {
        this.ps.setPages(pages);
      }
        this.router.navigateByUrl('user/' + this.ls.getCurrentUser().uName + '/page');
    });
  }

  edit() {
    this.router.navigateByUrl('user/' + this.ls.getCurrentUser().uName + '/edit');
  }

  explore() {
    this.router.navigateByUrl('search');
  }

  logout() {
    this.ls.setUser(null);
    this.router.navigateByUrl('login');
  }
}
