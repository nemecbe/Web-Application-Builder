import { Injectable, SkipSelf, Optional } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DroppableService {
  // $ is a naming convention for observables
  dragStart$: Observable<PointerEvent>;

  dragEnd$: Observable<PointerEvent>;

  private dragStartSubject = new Subject<PointerEvent>();
  private dragEndSubject = new Subject<PointerEvent>();
  private parent: DroppableService;

  constructor(@SkipSelf() @Optional() theParent: DroppableService) {
    this.dragStart$ = this.dragStartSubject.asObservable();
    this.dragEnd$ = this.dragEndSubject.asObservable();
    // console.log('service created with parent: ', parent);
    this.parent = theParent;
  }

  onDragStart(event: PointerEvent): void {
    // put all additional logic here
    this.dragStartSubject.next(event);
    if (this.parent) {
      this.parent.onDragStart(event);
    }
  }

  onDragEnd(event: PointerEvent): void {
    this.dragEndSubject.next(event);
    if (this.parent) {
      this.parent.onDragEnd(event);
    }
  }
}
