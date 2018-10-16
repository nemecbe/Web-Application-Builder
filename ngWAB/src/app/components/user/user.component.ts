import { Component, OnInit, Input } from '@angular/core';
import { User } from '../../types/user';
import { LoginServiceService } from '../../services/login-service.service';
import { Page } from 'src/app/types/page';
import { PageService } from 'src/app/services/page.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private ls: LoginServiceService, private ps: PageService, private router: Router) { }
  user: User;
  pages: Page[];

  ngOnInit() {
    this.user = this.ls.getCurrentUser();
  }

  getPages(): void {
    console.log(this.user);
    this.ps.getPages(this.user).subscribe(data => {
      this.pages = data;
      if (this.pages) {
        this.ps.setPages(this.pages);
      }
        this.router.navigateByUrl(this.router.url + '/page');
    });
  }

}
