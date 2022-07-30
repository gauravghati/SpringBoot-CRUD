package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Employee;
import com.springboot.ecommerce.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee delete Successfully", HttpStatus.OK);
    }
}
