import { Directive, TemplateRef, ViewContainerRef, OnInit, OnDestroy  } from '@angular/core';
import { DraggableDirective } from '../Draggable Directive/draggable.directive';
import { Overlay, OverlayRef, GlobalPositionStrategy } from '@angular/cdk/overlay';
import { TemplatePortal } from '@angular/cdk/portal';

@Directive({
  selector: '[appDraggableHelper]',
  exportAs: 'appDraggableHelper'
})
export class DraggableHelperDirective implements OnInit, OnDestroy {

  private overlayRef: OverlayRef;

  private startPosition?: { x: number; y: number };

  private positionStrategy = new GlobalPositionStrategy();

  constructor(private draggable: DraggableDirective,
              private viewContainerRef: ViewContainerRef,
              private templateRef: TemplateRef<any>,
              private overlay: Overlay) { }

  private onDragStart(event: PointerEvent): void {
    // render the helper in the overlay
    // this.overlayRef.attach(new TemplatePortal(this.templateRef, this.viewContainerRef));

    //    this.viewContainerRef.createEmbeddedView(this.templateRef);
    // determine relative star postition
    const clientRect = this.draggable.elementRef.nativeElement.getBoundingClientRect();
    this.startPosition = {
      x: event.clientX - clientRect.left,
      y: event.clientY - clientRect.top
    };
  }

  private onDragEnd(): void {
    // remove the helper from the overlay
    this.overlayRef.detach();
    // this.viewContainerRef.clear();
  }

  onDragMove(event: PointerEvent): void {
    if (!this.overlayRef.hasAttached()) {
      this.overlayRef.attach(new TemplatePortal(this.templateRef, this.viewContainerRef));
    }
    // position the helper...
    this.positionStrategy.left(`${event.clientX - this.startPosition.x}px`);
    this.positionStrategy.top(`${event.clientY - this.startPosition.y}px`);
    this.positionStrategy.apply();
  }

  ngOnInit(): void {
    this.draggable.dragStart.subscribe(event => this.onDragStart(event));
    this.draggable.dragMove.subscribe(event => this.onDragMove(event));
    this.draggable.dragEnd.subscribe(() => this.onDragEnd());

    // create an overlay
    this.overlayRef = this.overlay.create({
      positionStrategy: this.positionStrategy,
      panelClass: 'draggable-helper-overlay'
    });

  }

  ngOnDestroy(): void {
    // remove the overlay
    this.overlayRef.dispose();
  }
}
