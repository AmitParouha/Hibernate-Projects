package com.spring.jpa.controller;

import com.spring.jpa.payload.EmployeeDto;
import com.spring.jpa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(
            @RequestBody EmployeeDto employeeDto,
            @RequestParam("image") MultipartFile image
            ){

        if (image.isEmpty()) {
            System.out.println("Please select a file to upload");
            return null;
        }

        // Process the uploaded file (e.g., save it to disk)
        // For demonstration, we'll just return the filename
        String fileName = image.getOriginalFilename();
        System.out.println("Uploaded: " + fileName);

        EmployeeDto createdDto = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int id){
        EmployeeDto createdDto = employeeService.getEmployee(id);
        return ResponseEntity.ok(createdDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> createdDto = employeeService.getAllEmployee();
        return ResponseEntity.ok(createdDto);
    }
}
