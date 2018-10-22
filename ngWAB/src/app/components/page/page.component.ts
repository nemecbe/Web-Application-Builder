import { Component, OnInit } from '@angular/core';
import { Page } from 'src/app/types/page';
import { PageService } from 'src/app/services/page.service';
import { CompService } from 'src/app/services/comp.service';
import { Comp } from 'src/app/types/comp';
import { Router, ActivatedRoute } from '@angular/router';
import { SafeHtml, DomSanitizer } from '@angular/platform-browser';
import { PageComp } from '../../types/pageComps';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {

  pages: Page[];
  comps: PageComp[];
  currPage: Page;
  pageHtml: string;
  sh: SafeHtml;
  pageName = '';

  constructor(private ps: PageService,
              private cs: CompService,
              private router: Router,
              private sanitizer: DomSanitizer,
              private route: ActivatedRoute) {
    this.pageHtml = '';
  }

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
        // console.log(this.comps);
        this.cs.setComps(this.comps);
      }
      this.router.navigateByUrl(this.router.url + '/' + page.pId);
    });
    // this.sh = this.sanitizer.bypassSecurityTrustHtml(this.pageHtml);

    // this.pages.
  }

  addPage() {
    /*this.ps.createPage({
      pId: 0,
      active: true,
      pName: this.pageName,
      puId: this.ps.currUser.id
    }).subscribe(data => this.pages.push(data));*/
  }

}
