package com.example.employee.service;

import com.example.employee.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private EmployeeServiceImpl service;

    @BeforeEach void setUp() { service = new EmployeeServiceImpl(); }

    @Test void registersEmployeeAndAssignsId() {
        Employee saved = service.register(new Employee(null, "Asha Rao", "asha@example.com", "Engineering", 55000));
        assertNotNull(saved.getId());
        assertEquals("Asha Rao", saved.getName());
        assertEquals(1, service.findAll().size());
    }

    @Test void trimsEmployeeFields() {
        Employee saved = service.register(new Employee(null, " Asha Rao ", " asha@example.com ", " Engineering ", 55000));
        assertEquals("Asha Rao", saved.getName());
        assertEquals("asha@example.com", saved.getEmail());
        assertEquals("Engineering", saved.getDepartment());
    }

    @Test void rejectsBlankName() {
        assertThrows(IllegalArgumentException.class,
            () -> service.register(new Employee(null, " ", "asha@example.com", "Engineering", 55000)));
    }

    @Test void rejectsInvalidEmail() {
        assertThrows(IllegalArgumentException.class,
            () -> service.register(new Employee(null, "Asha", "not-an-email", "Engineering", 55000)));
    }

    @Test void rejectsNonPositiveSalary() {
        assertThrows(IllegalArgumentException.class,
            () -> service.register(new Employee(null, "Asha", "asha@example.com", "Engineering", 0)));
    }

    @Test void returnsEmployeesInIdOrder() {
        service.register(new Employee(null, "Asha", "asha@example.com", "Engineering", 55000));
        service.register(new Employee(null, "Ravi", "ravi@example.com", "Sales", 45000));
        List<Employee> employees = service.findAll();
        assertEquals(2, employees.size());
        assertTrue(employees.get(0).getId() < employees.get(1).getId());
    }
}
