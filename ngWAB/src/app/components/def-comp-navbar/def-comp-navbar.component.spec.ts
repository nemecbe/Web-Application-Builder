import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DefCompNavbarComponent } from './def-comp-navbar.component';

describe('DefCompNavbarComponent', () => {
  let component: DefCompNavbarComponent;
  let fixture: ComponentFixture<DefCompNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DefCompNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefCompNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
