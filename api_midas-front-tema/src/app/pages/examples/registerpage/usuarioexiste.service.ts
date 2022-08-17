import { Injectable } from '@angular/core';
import { AbstractControl } from '@angular/forms';
import { RegisterpageService } from './registerpage.service';
import { first, map, switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsuarioexisteService {

  constructor(private registerpageService: RegisterpageService) { }

  usuarioJaExiste() {
    return (control:AbstractControl) => {
      return control.valueChanges.pipe(
        switchMap((email)=>this.registerpageService.verificarUsuarioExistente(email)),
        map((usuarioExiste)=>(usuarioExiste ? {usuarioExistente:true} : null)),
        first()
      );
    };
  }
}
