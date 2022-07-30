import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListConsigmentComponent } from './list-consigment.component';

describe('ListConsigmentComponent', () => {
  let component: ListConsigmentComponent;
  let fixture: ComponentFixture<ListConsigmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListConsigmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListConsigmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
