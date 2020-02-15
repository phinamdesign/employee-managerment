package com.codegym.employee.Repository;

import com.codegym.employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Iterable<Employee> findEmployeeByFirstName(String firstName);
}
