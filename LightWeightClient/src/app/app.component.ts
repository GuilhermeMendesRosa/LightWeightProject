import {CommonModule} from '@angular/common';
import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';

import {
  PoMenuItem,
  PoMenuModule,
  PoPageModule,
  PoToolbarModule,
} from '@po-ui/ng-components';
import {PoPageLogin, PoPageLoginModule} from "@po-ui/ng-templates";
import {AuthService} from "./services/auth.service";
import {User} from "./models/User";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    PoToolbarModule,
    PoMenuModule,
    PoPageModule,
    PoPageLoginModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  constructor(private authService: AuthService) {
  }

  readonly menus: Array<PoMenuItem> = [
    {label: 'Home', action: this.onClick.bind(this)},
  ];

  private onClick() {
    alert('Clicked in menu item');
  }

  loginSubmit(formData: PoPageLogin) {
    const user: User = {
      login: formData.login,
      password: formData.password
    };
    this.authService.login(user).subscribe(value => {
      console.log(value)
    })
  }
}
