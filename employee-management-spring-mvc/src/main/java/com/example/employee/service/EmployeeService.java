package com.example.employee.service;

import com.example.employee.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee register(Employee employee);
    List<Employee> findAll();
}
