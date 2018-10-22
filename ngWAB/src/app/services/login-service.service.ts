import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../types/user';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  user1: Observable<User>;
  currentUser: User;
  readonly url = 'http://localhost:8080/FingersCrossed/login';

  readonly updateUrl = 'http://localhost:8080/FingersCrossed/user/';

  constructor(private http: HttpClient) { }

  getUser(user: User): Observable<User> {
      return this.http.post<User>(this.url, user, httpOptions);
  }

  setUser(user: User) {
    this.currentUser = user;
  }

  getCurrentUser(): User {
    return this.currentUser;
  }

  updateUser(user: User) {
    this.currentUser = user;
    this.http.put<User>(this.updateUrl + user.uName, user, httpOptions).subscribe();
  }
}
