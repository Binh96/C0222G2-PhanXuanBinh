import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsigmentComponent } from './consigment.component';

describe('ConsigmentComponent', () => {
  let component: ConsigmentComponent;
  let fixture: ComponentFixture<ConsigmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsigmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsigmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
