import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent { 
  message: string = '';
  user: string;
  pass: string;
  constructor(private userService: UserService, private router: Router, private authService: AuthService,
     private cookieService: CookieService) {}
  login() {
    this.userService.login(this.user, this.pass).subscribe( res => {
      if (res.accessToken != null) {
        this.message = '';
        // save user info, then redirect to dashboard
        this.cookieService.set('userInfo', JSON.stringify(""));
        this.cookieService.set('token', res.accessToken);
        this.authService.setLoggedIn(true);
        this.router.navigate(['/dashboard']);
        console.log("login thanh cong")
      } else {
        // this.message = res.message;
      }

      console.log(res)
    });
  }
}
