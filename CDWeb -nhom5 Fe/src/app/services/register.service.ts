import { Injectable } from '@angular/core';
import { Department } from '../models/department';
import { Observable } from 'rxjs';
import { Paging } from '../models/paging';
import { RootObj } from '../models/root-obj';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private apiService: ApiService) { 
  
}
