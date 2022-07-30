package com.springboot.ecommerce.service;

import com.springboot.ecommerce.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);
}
