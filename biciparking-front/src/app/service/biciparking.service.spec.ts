import { TestBed } from '@angular/core/testing';

import { BiciparkingService } from './biciparking.service';

describe('BiciparkingService', () => {
  let service: BiciparkingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BiciparkingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
