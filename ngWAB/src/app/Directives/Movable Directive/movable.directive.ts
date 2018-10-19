import { Directive, HostBinding, HostListener, Input, ElementRef, ViewContainerRef } from '@angular/core';
import { DraggableDirective } from '../Draggable Directive/draggable.directive';
import { DomSanitizer, SafeStyle } from '@angular/platform-browser';

export interface Position {
  x: number;
  y: number;
}

@Directive({
  selector: '[appMovable]'
})
export class MovableDirective extends DraggableDirective/* implements OnInit */{

  @HostBinding('style.transform') get transform(): SafeStyle {
    return this.santitizer.bypassSecurityTrustStyle(
      `translateX(${this.postition.x}px) translateY(${this.postition.y}px)`
      );
  }

  @HostBinding('class.movable') movable = true;

   postition: Position = {x: 0, y: 0};

  private startPosition: Position;

  @Input() resetPosition = false;

  constructor(private santitizer: DomSanitizer,
              public element: ElementRef,
              private viewContainer: ViewContainerRef ) {
    super(element);
   }
/* How I would think to do it:
  constructor(private draggable: DraggableDirective) { }


  ngOnInit(): void {
    this.draggable.dragStart.subscribe(() => this.onDragStart())
  }
*/
// The better way:
  @HostListener('dragStart', [`$event`])
  onDragStart(event: PointerEvent) {
    // console.log('start moving!');
    event.stopPropagation();
    this.startPosition = {
      x: event.clientX - this.postition.x,
      y: event.clientY - this.postition.y
    };
  }

  @HostListener('dragMove', [`$event`])
  onDragMove(event: PointerEvent) {
    // console.log('currently moving!');
    this.postition.x = event.clientX - this.startPosition.x;
    this.postition.y = event.clientY - this.startPosition.y;
    // console.log(this.postition.x);
  }

  @HostListener('dragEnd', [`$event`])
  onDragEnd(event: PointerEvent) {
    // console.log('done moving!');
    if (this.resetPosition) {
      this.postition = { x: 0, y: 0 };
    }
  }
}
