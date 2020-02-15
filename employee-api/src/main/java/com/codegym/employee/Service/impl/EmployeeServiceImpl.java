package com.codegym.employee.Service.impl;

import com.codegym.employee.Model.Employee;
import com.codegym.employee.Repository.EmployeeRepository;
import com.codegym.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Iterable<Employee> findEmployeeByFirstName(String firstName) {
        return employeeRepository.findEmployeeByFirstName(firstName);
    }
}
