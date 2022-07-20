import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertFacilityComponent } from './insert-facility.component';

describe('InsertFacilityComponent', () => {
  let component: InsertFacilityComponent;
  let fixture: ComponentFixture<InsertFacilityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertFacilityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertFacilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
