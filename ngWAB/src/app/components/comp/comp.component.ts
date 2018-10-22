import { Component, OnInit, Input, AfterViewInit } from '@angular/core';
import { Comp } from 'src/app/types/comp';
import { PageComp } from '../../types/pageComps';

@Component({
  selector: 'app-comp',
  templateUrl: './comp.component.html',
  styleUrls: ['./comp.component.css']
})
export class CompComponent implements OnInit, AfterViewInit {

  comps: string[];
  @Input() pageComp: PageComp;

  constructor() { }

  ngOnInit() {
    // this.comp = 'button';
  }

  ngAfterViewInit() {
    console.log('in compComponent');
    console.log(this.pageComp);
  }

}
