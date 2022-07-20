import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularCountdowTimerComponent } from './angular-countdow-timer.component';

describe('AngularCountdowTimerComponent', () => {
  let component: AngularCountdowTimerComponent;
  let fixture: ComponentFixture<AngularCountdowTimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularCountdowTimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularCountdowTimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
