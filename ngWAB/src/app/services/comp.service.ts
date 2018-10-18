import { Injectable } from '@angular/core';
import { Page } from '../types/page';
import { Comp } from '../types/comp';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginServiceService } from './login-service.service';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CompService {

  readonly url = 'http://localhost:8080/FingersCrossed/user/';

  comps: Comp[];
  constructor(private router: Router, private http: HttpClient, private ls: LoginServiceService) { }

  getComps(page: Page): Observable<Comp[]> {
    return this.http.get<Comp[]>(this.url + this.ls.getCurrentUser().uName + '/page/' + page.pId, httpOptions);
  }
  setComps(comps: Comp[]) {
    this.comps = comps;
  }
}
