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
  page: Page;

  ngOnInit() {
    this.user = this.ls.getCurrentUser();
  }

  getPages(): void {
    this.page.puId = this.user.id;
    this.ps.getPages(this.page).subscribe(data => {
      this.page = data;
      if (this.page) {
        this.ps.setPage(this.page);
      }
        this.router.navigateByUrl(this.router.url + '/page');
    });
  }

}
