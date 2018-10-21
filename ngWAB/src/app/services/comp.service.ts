import { Injectable } from '@angular/core';
import { Page } from '../types/page';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginServiceService } from './login-service.service';
import { PageComp } from 'src/app/types/pageComps';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CompService {

  readonly url = 'http://localhost:8080/FingersCrossed/user/';
  currPage: Page;
  comps: PageComp[];
  constructor(private router: Router, private http: HttpClient, private ls: LoginServiceService) { }

  getComps(page: Page): Observable<PageComp[]> {
    this.currPage = page;
    return this.http.get<PageComp[]>(this.url + this.ls.getCurrentUser().uName + '/page/' + page.pId, httpOptions);
  }

  getCompsById(pId: string): Observable<PageComp[]> {
    return this.http.get<PageComp[]>(this.url + this.ls.getCurrentUser() + '/page/' + pId, httpOptions);
  }
  setComps(comps: PageComp[]) {
    this.comps = comps;
  }
  getCurrPage() {
    return this.currPage;
  }

  getCurrComps() {
    return this.comps;
  }
}
