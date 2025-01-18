package com.spring.jpa.controller;

import com.spring.jpa.payload.EmployeeDto;
import com.spring.jpa.payload.StudentDto;
import com.spring.jpa.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> saveEmployee(@RequestBody StudentDto studentDto){
        StudentDto createdStudent = studentService.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getEmployee(@PathVariable int id){
        StudentDto studentDto = studentService.getStudent(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllEmployee(){
        List<StudentDto> studentDto = studentService.getAllStudent();
        return ResponseEntity.ok(studentDto);
    }

}
