import { Component, OnInit } from '@angular/core';
import { Page } from '../../types/page';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  input: string;
  pages: Page[];
  page1: Page;
  page2: Page;

  constructor(private router: Router) {
    this.pages = [];
    this.page1 = {
      pId: 1,
      puId: 1,
      pName: 'example1',
      active: true
    };
    this.page2 = {
      pId: 2,
      puId: 2,
      pName: 'name2',
      active: true
    };
  }

  ngOnInit() {
    this.pages = [ this.page1, this.page2 ];
  }

  goToPage(page: Page) {
    this.router.navigateByUrl('page/' + page.pName);
  }

}
