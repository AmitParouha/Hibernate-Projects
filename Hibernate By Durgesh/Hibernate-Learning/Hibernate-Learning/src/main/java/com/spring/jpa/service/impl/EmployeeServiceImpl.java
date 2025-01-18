package com.spring.jpa.service.impl;

import com.spring.jpa.entity.Employee;
import com.spring.jpa.exception.EmployeeNotFoundException;
import com.spring.jpa.payload.EmployeeDto;
import com.spring.jpa.repository.EmployeeRepository;
import com.spring.jpa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private ModelMapper mapper;
    private EmployeeRepository repository;


    private Employee mapToEmployee(EmployeeDto  employeeDto){
        return mapper.map(employeeDto, Employee.class);
    }

    private EmployeeDto mapToEmployeeDto(Employee  employee){
        return mapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        return mapToEmployeeDto(repository.save(employee));
    }

    @Override
    public EmployeeDto getEmployee(int id) {
        Employee employee = repository.findById(id)
                .orElseThrow(
                        ()->new EmployeeNotFoundException("Employee "+id+" is not found"));

        return mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = repository.findAll();
        if(employees.size()==0){
            throw new EmployeeNotFoundException("There is no any employee existed ");
        }

        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> mapToEmployeeDto(employee)).collect(Collectors.toList());

        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(int id, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto deleteEmployee(int id) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }
}
