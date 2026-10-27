package com.example.employee.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Employee {
    private Long id;

    @NotBlank(message = "Name is required.")
    @Size(max = 80, message = "Name must be 80 characters or fewer.")
    private String name;

    @NotBlank(message = "Email is required.")
    @Email(message = "Enter a valid email address.")
    private String email;

    @NotBlank(message = "Department is required.")
    @Size(max = 60, message = "Department must be 60 characters or fewer.")
    private String department;

    @Positive(message = "Salary must be greater than zero.")
    private double salary;

    public Employee() {}
    public Employee(Long id, String name, String email, String department, double salary) {
        this.id=id; this.name=name; this.email=email; this.department=department; this.salary=salary;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public String getDepartment(){return department;} public void setDepartment(String department){this.department=department;}
    public double getSalary(){return salary;} public void setSalary(double salary){this.salary=salary;}
}
