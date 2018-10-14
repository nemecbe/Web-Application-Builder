import { Component, OnInit, Input } from '@angular/core';
import { User } from '../../types/user';
import { LoginServiceService } from '../../services/login-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private ls: LoginServiceService) { }
  user: User;

  ngOnInit() {
    this.user = this.ls.getCurrentUser();
  }

}
