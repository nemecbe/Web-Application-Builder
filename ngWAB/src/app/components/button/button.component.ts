import { Component, OnInit, Input } from '@angular/core';
import { PageComp } from 'src/app/types/pageComps';
import { Position } from '../../Directives/Movable Directive/movable.directive';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {

  pos: Position;

  @Input() pageComp: PageComp;

  value: string;
  // look into styling

  constructor() { }

  ngOnInit() {
    this.value = 'default button';
    this.pos = { x: this.pageComp.xPos, y: this.pageComp.yPos };
  }

  onClick() {
    this.value = this.pageComp.compDetails;
  }

}
