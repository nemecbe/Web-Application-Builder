import { Directive, OnInit, HostBinding, HostListener, Output, EventEmitter, SkipSelf } from '@angular/core';
import { DroppableService } from '../services/droppable.service';

@Directive({
  selector: '[appDropzone]',
  providers: [DroppableService]
})
export class DropzoneDirective implements OnInit {

  @Output() drop = new EventEmitter<PointerEvent>();
  @Output() remove = new EventEmitter<PointerEvent>();

  @HostBinding('class.dropzone-activated') activated = false;
  @HostBinding('class.dropzone-entered') entered = false;


  @HostListener('pointerenter')
  onPointerEnter(): void {
    if (this.activated) {
      this.entered = true;
    }
  }

  @HostListener('pointerleave')
  onPointerLeave(): void {
    if (this.activated) {
      this.entered = false;
    }
  }

  constructor(@SkipSelf() private globalDroppableService: DroppableService,
    private innerDroppableService: DroppableService) {

    }

  ngOnInit(): void {
    this.globalDroppableService.dragStart$.subscribe(() => this.onDragStart());
    this.globalDroppableService.dragEnd$.subscribe(event => this.onDragEnd(event));
    this.innerDroppableService.dragStart$.subscribe(() => this.onInnerDragStart());
    this.innerDroppableService.dragEnd$.subscribe(event => this.onInnerDragEnd(event));
  }

  private onDragStart(): void {
    this.activated = true;
  }

  private onDragEnd(event: PointerEvent): void {
    if (!this.activated) {
      return;
    }
    if (this.entered) {
      // we have a drop!
      // console.log('drop');
      this.drop.emit(event);
    }
    this.activated = false;
    this.entered = false;
  }

  private onInnerDragStart(): void {
    this.activated = true;
    this.entered = true;
  }

  private onInnerDragEnd(event: PointerEvent): void {
    if (!this.entered) {
      this.remove.emit(event);
    }
    this.activated = false;
    this.entered = false;
  }
}
