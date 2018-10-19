import { Directive, HostBinding, HostListener, Output, EventEmitter,
    Input, TemplateRef, ViewContainerRef, ContentChild, ElementRef } from '@angular/core';

  @Directive({
    selector: '[appDraggable], [appDroppable]'
  })
  export class DraggableDirective {

    constructor(public elementRef: ElementRef) { }

    @HostBinding('class.draggable') draggable = true;

    @HostBinding('class.dragging') dragging = false;

    @HostBinding('attr.touch-action')touchAction = 'none';

    @Output() dragStart = new EventEmitter<PointerEvent>();
    @Output() dragMove = new EventEmitter<PointerEvent>();
    @Output() dragEnd = new EventEmitter<PointerEvent>();

    // @ContentChild(DraggableHelperDirective) helper: DraggableHelperDirective;

    // pointerdown =>dragStart
    @HostListener('pointerdown', [`$event`])
    onpointerdown(event: PointerEvent): void {
      this.dragging = true;
      this.dragStart.emit(event);
      // render the helper template
      // this.helper.onDragStart();
    }

    // document => pointermove => dragMove
    @HostListener('document:pointermove', [`$event`])
    onpointermove(event: PointerEvent): void {
      if ( !this.dragging ) {
        return;
      }
      this.dragMove.emit(event);
    }
    // document => pointerup => dragEnd
    @HostListener('document:pointerup', [`$event`])
    onPointerUp(event: PointerEvent): void {
      if (!this.dragging) {
        return;
      }
      this.dragEnd.emit(event);
      this.dragging = false;
      // remove the helper:
      // this.helper.onDragEnd();
    }
  }
