import { Directive, HostListener } from '@angular/core';
import { DroppableService } from '../services/droppable.service';

@Directive({
  selector: '[appDroppable]'
})
export class DroppableDirective {

  constructor(private droppableService: DroppableService) { }

  @HostListener('dragStart', ['$event'])
  onDragStart(event: PointerEvent): void {
    this.droppableService.onDragStart(event);
  }

  @HostListener('dragEnd', ['$event'])
  ondragend(event: PointerEvent): void {
    this.droppableService.onDragEnd(event);
  }

}
