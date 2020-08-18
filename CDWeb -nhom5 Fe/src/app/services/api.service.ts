import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private http: HttpClient,private cookieService: CookieService) {
  }
  baseUrl = 'http://localhost:8081/';
  apiUrl = {
    users: {
      home: `${this.baseUrl}authen`,
      login: `${this.baseUrl}authen/login`
    },
    employees: {
      home: `${this.baseUrl}employees`,
      images: `${this.baseUrl}uploads/images/employees/`,
      canimg: `${this.baseUrl}uploads/images/candidates/`,
      jobInformations: `${this.baseUrl}employees/job-informations`,
    },
    candidates: {
      home: `${this.baseUrl}candidates`,
      type: `${this.baseUrl}candidates/type`,

    },
    notes: {
      home: `${this.baseUrl}notes`,
    },
    mails:{
      home: `${this.baseUrl}mails`,
    },
    timeKeepingDetail: {
      home: `${this.baseUrl}time-keeping-detail`,
      monrning: `${this.baseUrl}time-keeping-detail/morning`,
      afteroon: `${this.baseUrl}time-keeping-detail/afternoon`

    },
    departments: {
      home: `${this.baseUrl}departments`
    },
    degrees: {
      home: `${this.baseUrl}degrees`
    },
    shifts: {
      home: `${this.baseUrl}shifts`
    },
    workingTimes: {
      home: `${this.baseUrl}working-times`
    },
    timeSlots: {
      home: `${this.baseUrl}time-slots`
    },
    location:{
      province: `${this.baseUrl}addresses/province`,
      district: `${this.baseUrl}addresses/district`,
      ward: `${this.baseUrl}addresses/ward`,
      address: `${this.baseUrl}addresses/address`
    },
    timekeeping: {
      home: `${this.baseUrl}timeKeeping`,

      creat: `${this.baseUrl}timeKeeping`,
      morning:`${this.baseUrl}timeKeeping/morning`,
      afternoon:`${this.baseUrl}timeKeeping/afternoon`,
      refet : `${this.baseUrl}timeKeeping/refet`,
      close : `${this.baseUrl}timeKeeping/close`
    },
    schedule: {
      home: `${this.baseUrl}schedules`,
    },
    salary: {
      counting: `${this.baseUrl}salaries/counting`,
      increasing: `${this.baseUrl}salaries/increasing`,
      histories: `${this.baseUrl}salaries/histories`

    },
  };

  get<T>(url: string): Observable<T> {
    return this.http.get<T>(url);
  }
  post<T>(url: string, data: Object): Observable<T> {
    return this.http.post<T>(url, data);
  }
  put<T>(url: string, data: Object): Observable<T> {
    return this.http.put<T>(url, data);
  }
  delete<T>(url: string): Observable<T> {
    return this.http.delete<T>(url);
  }
}
