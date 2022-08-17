import { TestBed } from '@angular/core/testing';

import { RegisterpageService } from './registerpage.service';

describe('RegisterpageService', () => {
  let service: RegisterpageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterpageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
