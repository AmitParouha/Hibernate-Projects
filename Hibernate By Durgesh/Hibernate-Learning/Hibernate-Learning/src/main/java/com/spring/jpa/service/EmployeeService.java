package com.spring.jpa.service;

import com.spring.jpa.entity.Employee;
import com.spring.jpa.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployee(int id);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updateEmployee(int id, EmployeeDto employeeDto);
    public EmployeeDto deleteEmployee(int id);
    public String deleteAll();

}
