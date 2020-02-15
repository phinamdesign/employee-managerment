package com.codegym.employee.Service;

import com.codegym.employee.Model.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(Long id);

    Iterable<Employee> findAll();

    Employee save(Employee employee);

    void delete(Long id);

    Iterable<Employee> findEmployeeByFirstName(String firstName);
}
