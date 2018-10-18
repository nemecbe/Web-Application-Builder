import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Page } from '../types/page';
import { Observable } from 'rxjs';
import { User } from '../types/user';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PageService {

  page: Observable<Page>;
  currUser: User;
  currPages: Page[];

  readonly url = 'http://localhost:8080/FingersCrossed/user/';

  constructor(private http: HttpClient) { }

  getPages(user: User): Observable<Page[]> {
    return this.http.get<Page[]>(this.url +  user.uName + '/page', httpOptions);
  }

  setPages(pages: Page[]) {
    this.currPages = pages;
  }

  getCurrPages(): Page[] {
    return this.currPages;
  }
}
