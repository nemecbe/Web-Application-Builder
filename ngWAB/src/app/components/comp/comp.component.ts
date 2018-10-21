import { Component, OnInit, Input } from '@angular/core';
import { Comp } from 'src/app/types/comp';
import { PageComp } from '../../types/pageComps';

@Component({
  selector: 'app-comp',
  templateUrl: './comp.component.html',
  styleUrls: ['./comp.component.css']
})
export class CompComponent implements OnInit {

  comps: string[];
  @Input() pageComp: PageComp;

  constructor() { }

  ngOnInit() {
    // this.comp = 'button';
  }

}
