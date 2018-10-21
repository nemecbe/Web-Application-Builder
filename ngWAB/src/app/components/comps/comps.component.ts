import { Component, OnInit, Input } from '@angular/core';
import { Comp } from 'src/app/types/comp';
import { PageComp } from '../../types/pageComps';
import { ActivatedRoute } from '@angular/router';
import { CompService } from 'src/app/services/comp.service';

@Component({
  selector: 'app-comps',
  templateUrl: './comps.component.html',
  styleUrls: ['./comps.component.css']
})
export class CompsComponent implements OnInit {

    @Input() comps: PageComp[];
    comp1: PageComp;
    comp2: PageComp;

  constructor(private route: ActivatedRoute, private cs: CompService) { }

  ngOnInit() {
    /*
    this.comp1 = { pcId: 1, compId: { id: 2, compName: 'button', compType: 'button'}, pageId: 1,
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
    this.comps = [this.comp1, this.comp2];
    // const pId = this.route.snapshot.paramMap.get('pId');
    // this.cs.getCompsById(pId).subscribe(data => {this.comps = data; console.log(this.comps); });
    console.log('in on init of comps');
    console.log(this.comps);
    */
  }

}
