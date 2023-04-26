import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8080/employee";
  constructor(private httpClient: HttpClient, private router: Router) { }

  goToEmployeeList() {
    this.router.navigate(["/employee"]);
  }
  getEmployeeList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseUrl);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(this.baseUrl, employee);
  }
  
  getEmployeeById(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(this.baseUrl + "/" + id);
  }

  updateEmployee(employee: Employee): Observable<Object> {
    return this.httpClient.put(this.baseUrl, employee);
  }
  
  deleteEmployee(id: number): Observable<Object> {
    return this.httpClient.delete(this.baseUrl + "/" + id);
  }
}
