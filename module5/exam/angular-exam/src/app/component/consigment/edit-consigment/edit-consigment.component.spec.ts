import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditConsigmentComponent } from './edit-consigment.component';

describe('EditConsigmentComponent', () => {
  let component: EditConsigmentComponent;
  let fixture: ComponentFixture<EditConsigmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditConsigmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditConsigmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
