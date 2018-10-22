import { Component, OnInit } from '@angular/core';
import { IndividualPageComponent } from '../individual-page/individual-page.component';
import { PageComp } from 'src/app/types/pageComps';
import { Button } from 'protractor';

@Component({
  selector: 'app-def-comp-navbar',
  templateUrl: './def-comp-navbar.component.html',
  styleUrls: ['./def-comp-navbar.component.css']
})
export class DefCompNavbarComponent implements OnInit {

  constructor(private ip: IndividualPageComponent) { }

  ngOnInit() {
  }

  addButton() {
    this.ip.comps.push({
      pcId: this.ip.comps.length + 1,
      compDetails: 'New Button',
      compId: { compName: 'button', compType: 'button', id: 1},
      pageId: 1,
      parentId: 0,
      styleId: 0,
      xPos: 0,
      yPos: 0
    });
  }

}
