import { TestBed } from '@angular/core/testing';

import { ConsigmentService } from './consigment.service';

describe('ConsigmentService', () => {
  let service: ConsigmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsigmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
