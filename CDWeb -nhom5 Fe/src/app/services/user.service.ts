import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Login } from '../models/login';
import { Observable } from 'rxjs';
import { RootObj } from '../models/root-obj';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private apiService: ApiService) { }
  login(user: string, pass: string): Observable<RootObj<Login>> {
    const data = {
      user: user,
      pass: pass,
    };
    return this.apiService.post<RootObj<Login>>(this.apiService.apiUrl.users.login, data);
  }
}
