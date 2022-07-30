import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertConsigmentComponent } from './insert-consigment.component';

describe('InsertConsigmentComponent', () => {
  let component: InsertConsigmentComponent;
  let fixture: ComponentFixture<InsertConsigmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertConsigmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertConsigmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
