import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit{

  id!: number;
  employee: Employee = new Employee;
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) {}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
      console.log(this.employee);
    },
    error => console.log(error)
    );
  }

  backToHome(){
    this.employeeService.goToEmployeeList();
  }




}
