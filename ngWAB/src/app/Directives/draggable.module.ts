import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DraggableDirective } from './Draggable Directive/draggable.directive';
import { MovableDirective } from './Movable Directive/movable.directive';
import { MovableAreaDirective } from './Movable Area Directive/movable-area.directive';
import { DraggableHelperDirective } from './Draggable Helper Directive/draggable-helper.directive';
import { OverlayModule } from '@angular/cdk/overlay';
import { DropzoneDirective } from './Dropzone Directive/dropzone.directive';
import { DroppableDirective } from './Droppable Directive/droppable.directive';
import { DroppableService } from './services/droppable.service';
import { ComponentService } from './services/component.service';
import { ComponentStylingService } from './services/component-styling.service';

@NgModule({
  imports: [
    CommonModule,
    OverlayModule
  ],
  declarations: [
    DraggableDirective,
    MovableDirective,
    MovableAreaDirective,
    DraggableHelperDirective,
    DropzoneDirective,
    DroppableDirective
  ],
  exports: [
    DraggableDirective,
    MovableDirective,
    MovableAreaDirective,
    DraggableHelperDirective,
    DropzoneDirective,
    DroppableDirective
  ],
  providers: [
    DroppableService,
    ComponentService,
    ComponentStylingService
  ]
})
export class DraggableModule { }
