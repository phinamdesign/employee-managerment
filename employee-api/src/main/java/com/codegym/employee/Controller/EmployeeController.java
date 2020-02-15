package com.codegym.employee.Controller;

import com.codegym.employee.Model.Employee;
import com.codegym.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<?> listEmployee(){
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        if (employees.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable Long id){
        Optional<Employee> employee1 = employeeService.findById(id);
        if (!employee1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee1.get().setFirstName(employee.getFirstName());
        employee1.get().setLastName(employee.getLastName());
        employee1.get().setEmailId(employee.getEmailId());
        employeeService.save(employee1.get());

        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
