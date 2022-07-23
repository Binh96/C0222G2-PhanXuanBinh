import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdentityRevealedComponent } from './identity-revealed.component';

describe('IdentityRevealedComponent', () => {
  let component: IdentityRevealedComponent;
  let fixture: ComponentFixture<IdentityRevealedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdentityRevealedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdentityRevealedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
