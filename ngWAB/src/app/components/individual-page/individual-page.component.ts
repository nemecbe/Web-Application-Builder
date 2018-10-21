import { Component, OnInit } from '@angular/core';
import { PageComp } from 'src/app/types/pageComps';
import { CompService } from 'src/app/services/comp.service';
import { Page } from 'src/app/types/page';
import { PageService } from 'src/app/services/page.service';

@Component({
  selector: 'app-individual-page',
  templateUrl: './individual-page.component.html',
  styleUrls: ['./individual-page.component.css']
})
export class IndividualPageComponent implements OnInit {

  comps: PageComp[];
  page: Page;
  comp1: PageComp;
  comp2: PageComp;

  constructor(private cs: CompService) { }

  ngOnInit() {
    /*this.comp1 = { pcId: 1, compId: { id: 2, compName: 'button', compType: 'button'}, pageId: 1,
    parentId: 1,
    compDetails: 'string',
    styleId: 11,
    xPos: 1,
    yPos: 1};
    this.comp2 = { pcId: 1, compId: { id: 2, compName: 'button', compType: 'button'}, pageId: 1,
    parentId: 1,
    compDetails: 'string',
    styleId: 11,
    xPos: 1,
    yPos: 1};
    this.comps = [this.comp1, this.comp2];*/
    this.comps = this.cs.getCurrComps();
    console.log(this.comps);
    console.log('still here!');
  }

}
