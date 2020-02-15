import { Component, OnInit } from '@angular/core';
import { Employee } from '../../Model/employee';
import { EmployeeService } from '../../Service/employee.service';
import { Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  id: number;
  employee: Employee;

  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.employee = new Employee();
    this.id = this.route.snapshot.params.id;
    this.employeeService.getEmployee(this.id)
      .subscribe(
      data => {
        console.log(data);
        this.employee = data;
      }, error => console.log(error));
  }

  listEmployee() {
    this.router.navigate(['employee']);
  }
}
