import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{

  id!: number;
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    },
    error => console.log(error));
  }


  updateEmployee(){
    this.employeeService.updateEmployee(this.employee).subscribe(data=> {
      console.log(data);
      this.employeeService.goToEmployeeList();
    },
    error => console.log(error));
  }

  onSubmit(){
    this.updateEmployee();
  }
}
