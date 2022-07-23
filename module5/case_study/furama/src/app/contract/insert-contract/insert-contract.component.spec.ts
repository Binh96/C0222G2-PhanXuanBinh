import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertContractComponent } from './insert-contract.component';

describe('InsertContractComponent', () => {
  let component: InsertContractComponent;
  let fixture: ComponentFixture<InsertContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
