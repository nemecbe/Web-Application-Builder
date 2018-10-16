import { Component, OnInit } from '@angular/core';
import { Page } from 'src/app/types/page';
import { PageService } from 'src/app/services/page.service';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {

  pages: Page[];

  constructor(private ps: PageService) { }

  ngOnInit() {
    this.pages = this.ps.getCurrPages();
    console.log(this.pages);
  }

}
