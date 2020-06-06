package com.Employee.payrollservice;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(Long id) {
        super(String.format("Employee not found with id %s",id));
    }
}
