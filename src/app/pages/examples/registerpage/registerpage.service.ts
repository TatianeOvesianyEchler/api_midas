import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Registerpage } from './registerpage';

@Injectable({
  providedIn: 'root'
})
export class RegisterpageService {

  constructor(private http: HttpClient) { }

  cadastraNovoUsuario(registerPage: Registerpage){
    return this.http.post('http://localhost:3000/registerpage', registerPage);
  }

  verificarUsuarioExistente(email:string) {
    return this.http.get(`http://localhost:3000/user/exists/${email}`)
  }
}
