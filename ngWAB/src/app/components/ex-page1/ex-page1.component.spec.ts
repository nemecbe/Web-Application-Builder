import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExPage1Component } from './ex-page1.component';

describe('ExPage1Component', () => {
  let component: ExPage1Component;
  let fixture: ComponentFixture<ExPage1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExPage1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExPage1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
