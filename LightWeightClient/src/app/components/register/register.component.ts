import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
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

  registerUser() {
    this.authService.register(this.login);
  }
}
