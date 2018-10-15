import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Page } from '../types/page';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PageService {

  page: Observable<Page>;
  currPage: Page;
  readonly url = 'http://localhost:8080/FingersCrossed/user/jmart/page';

  constructor(private http: HttpClient) { }

  getPages(page: Page): Observable<Page> {
    return this.http.post<Page>(this.url, page, httpOptions)
  }

  setPage(page: Page) {
    this.currPage = page;
  }

  getCurrPage(): Page {
    return this.currPage;
  }
}
