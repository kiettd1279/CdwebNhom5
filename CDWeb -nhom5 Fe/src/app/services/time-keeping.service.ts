import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Paging } from '../models/paging';
import { Observable, from } from 'rxjs';
import { RootObj } from '../models/root-obj';
import {Timekeeping } from '../models/timekeeping';
@Injectable({
  providedIn: 'root'
})
export class TimeKeepingService {

  constructor(private apiService: ApiService) { }

  closeTimeKeeping(): Observable<[Timekeeping]> {

      return this.apiService.get<[Timekeeping]>(`${this.apiService.apiUrl.timekeeping.close}`);
    }
  refetTimeKeeping(): Observable<[Timekeeping]> {
    //  const query = `page=${paging.page + 1}&page_limit=4`;
      return this.apiService.get<[Timekeeping]>(`${this.apiService.apiUrl.timekeeping.refet}`);
    }
  listTimeKeeping(): Observable<RootObj<[Timekeeping]>> {
  //  const query = `page=${paging.page + 1}&page_limit=4`;
    return this.apiService.get<RootObj<[Timekeeping]>>(`${this.apiService.apiUrl.timekeeping.home}`);
  }
  listTimeKeepingMorning(): Observable<[Timekeeping]> {
    
      return this.apiService.get<[Timekeeping]>(`${this.apiService.apiUrl.timekeeping.morning}`);
    }
    listTimeKeepingAfternoon(): Observable<[Timekeeping]> {
      //  const query = `page=${paging.page + 1}&page_limit=4`;
        return this.apiService.get<[Timekeeping]>(`${this.apiService.apiUrl.timekeeping.afternoon}`);
      }

    creatTimeKeepingDetailMorning (data :Timekeeping): Observable<RootObj<Timekeeping>>{
      return this.apiService.put<RootObj<Timekeeping>>(`${this.apiService.apiUrl.timekeeping.morning}/${data.id}`, data);
  }
  creatTimeKeepingDetailAfternoon (data :Timekeeping): Observable<RootObj<Timekeeping>>{
    return this.apiService.put<RootObj<Timekeeping>>(`${this.apiService.apiUrl.timekeeping.afternoon}/${data.id}`, data);
}

  
    
    save():  Observable<RootObj<[Timekeeping]>> {
    return this.apiService.post<RootObj<[Timekeeping]>>(this.apiService.apiUrl.timekeeping.creat, null);
    }
}
