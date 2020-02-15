import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from './Component/employee-list/employee-list.component';
import {CreateEmployeeComponent} from './Component/create-employee/create-employee.component';
import {UpdateEmployeeComponent} from './Component/update-employee/update-employee.component';
import {EmployeeDetailsComponent} from './Component/employee-details/employee-details.component';


const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employee', component: EmployeeListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  { path: 'details/:id', component: EmployeeDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
