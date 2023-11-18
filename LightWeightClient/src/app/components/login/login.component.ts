import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private authService: AuthService
  ) {
  }

  ngOnInit(): void {
  }

  login = {
    login: '',
    password: ''
  };

  loginUser() {
    this.authService.doLogin(this.login);
    // Adicione a lógica de autenticação adequada, por exemplo, fazendo uma chamada para um serviço de autenticação
  }
}
