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
  login(userName: string, password: string): Observable<RootObj<Login>> {
    const data = {
      userName: userName,
      password: password,
    };
    return this.apiService.post<RootObj<Login>>(this.apiService.apiUrl.users.login, data);
  }
}
