import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/types/user';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  user: User = {
    id: 0,
    uName: 'default',
    pWord: 'user',
    fName: 'default',
    lName: 'user',
    eMail: 'd_user@example.com'
  };

  fName = '';

  constructor(private ls: LoginServiceService) { }

  ngOnInit() {
    this.user = this.ls.currentUser;
    console.log(this.user);
  }

  update() {
    this.ls.updateUser(this.user);
  }

}
