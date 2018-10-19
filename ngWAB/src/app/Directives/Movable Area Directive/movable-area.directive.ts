import { Directive, ContentChildren, QueryList, AfterContentInit, ElementRef } from '@angular/core';
import { MovableDirective } from '../Movable Directive/movable.directive';
import { Subscription } from 'rxjs';

interface Boundary {
  minX: number;
  maxX: number;
  minY: number;
  maxY: number;
}

@Directive({
  selector: '[appMovableArea]'
})
export class MovableAreaDirective implements AfterContentInit {

  @ContentChildren(MovableDirective) movables: QueryList<MovableDirective>;

  private subscriptions: Subscription[] = [];

  constructor(private element: ElementRef) { }

  private boundaries: Boundary;

  ngAfterContentInit(): void {
    // console.log(this.movables.length);
    /*this.movables.forEach(movable => {
      movable.dragStart.subscribe(() => this.measureBoundaries(movable));
      movable.dragMove.subscribe(() => this.maintainBoundaries(movable));
    });*/
    this.movables.changes.subscribe(() => {
      this.subscriptions.forEach(s => s.unsubscribe());
      this.movables.forEach(movable => {
        this.subscriptions.push(movable.dragStart.subscribe(() => this.measureBoundaries(movable)));
        this.subscriptions.push(movable.dragMove.subscribe(() => this.maintainBoundaries(movable)));
      });
    });

    this.movables.notifyOnChanges();
  }

  private measureBoundaries(movable: MovableDirective) {
    // measure the boundaries here:
    // console.log('measuring..');
    // bounding rects:
    //  for area
    //  for movable
    const viewRect: ClientRect = this.element.nativeElement.getBoundingClientRect();
    const movableRect: ClientRect = movable.element.nativeElement.getBoundingClientRect();

    this.boundaries = {
      minX: viewRect.left - movableRect.left + movable.postition.x,
      minY: viewRect.top - movableRect.top + movable.postition.y,
      maxX: viewRect.right - movableRect.right + movable.postition.x,
      maxY: viewRect.bottom - movableRect.bottom + movable.postition.y,
    };
    // console.log('boundaries are: ', this.boundaries);
  }

  private maintainBoundaries(movable: MovableDirective) {
    // make sure that the movable stays within
    // the boundaries here:
    // console.log('maintaining ...');
    movable.postition.x = Math.max(movable.postition.x, this.boundaries.minX);
    movable.postition.y = Math.max(movable.postition.y, this.boundaries.minY);
    movable.postition.x = Math.min(movable.postition.x, this.boundaries.maxX);
    movable.postition.y = Math.min(movable.postition.y, this.boundaries.maxY);
  }
}
