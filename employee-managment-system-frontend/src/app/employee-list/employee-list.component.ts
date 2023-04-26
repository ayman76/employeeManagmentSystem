import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{

  ngOnInit(): void {
    this.employees = [
      {
        "id": 1,
        "firstName": "Ayman",
        "lastName": "Mohamed",
        "email": "ayman@gmail.com"
      },

      {
        "id": 2,
        "firstName": "Mohamed",
        "lastName": "Khaled",
        "email": "mohamed@gmail.com"
      }
    ]
  }

  constructor(){}

  employees!: Employee[];


}
