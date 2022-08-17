import { TestBed } from '@angular/core/testing';

import { UsuarioexisteService } from './usuarioexiste.service';

describe('UsuarioexisteService', () => {
  let service: UsuarioexisteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsuarioexisteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
