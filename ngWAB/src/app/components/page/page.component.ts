import { Component, OnInit } from '@angular/core';
import { Page } from 'src/app/types/page';
import { PageService } from 'src/app/services/page.service';
import { CompService } from 'src/app/services/comp.service';
import { Comp } from 'src/app/types/comp';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {

  pages: Page[];
  comps: Comp[];
  currPage: Page;

  constructor(private ps: PageService,
              private cs: CompService,
              private router: Router) { }

  ngOnInit() {
    this.pages = this.ps.getCurrPages();
    console.log(this.pages);
  }

  getComps(page: Page): void {
    console.log(page);
    this.currPage = page;
    this.cs.getComps(page).subscribe(data => {
      this.comps = data;
      if (this.comps) {
        this.cs.setComps(this.comps);
      }
      this.router.navigateByUrl(this.router.url + '/' + page.pId);
    });
  }

}
