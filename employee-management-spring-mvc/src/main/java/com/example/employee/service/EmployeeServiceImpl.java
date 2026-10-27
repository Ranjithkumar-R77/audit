package com.example.employee.service;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final ConcurrentHashMap<Long, Employee> employees = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Employee register(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee information is required.");
        if (employee.getName() == null || employee.getName().isBlank())
            throw new IllegalArgumentException("Employee name is required.");
        if (employee.getEmail() == null || !employee.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new IllegalArgumentException("A valid email address is required.");
        if (employee.getDepartment() == null || employee.getDepartment().isBlank())
            throw new IllegalArgumentException("Department is required.");
        if (employee.getSalary() <= 0 || Double.isNaN(employee.getSalary()) || Double.isInfinite(employee.getSalary()))
            throw new IllegalArgumentException("Salary must be a valid number greater than zero.");
        Employee saved = new Employee(sequence.incrementAndGet(), employee.getName().trim(),
                employee.getEmail().trim(), employee.getDepartment().trim(), employee.getSalary());
        employees.put(saved.getId(), saved);
        return saved;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> result = new ArrayList<>(employees.values());
        result.sort(Comparator.comparing(Employee::getId));
        return result;
    }
}
