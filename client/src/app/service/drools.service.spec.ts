/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { DroolsService } from './drools.service';

describe('Service: Drools', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DroolsService]
    });
  });

  it('should ...', inject([DroolsService], (service: DroolsService) => {
    expect(service).toBeTruthy();
  }));
});
