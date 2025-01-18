package com.spring.jpa.service;

import com.spring.jpa.entity.Student;
import com.spring.jpa.payload.StudentDto;

import java.util.List;

public interface StudentService {

    public StudentDto addStudent(StudentDto studentDto);
    public StudentDto getStudent(int id);
    public List<StudentDto> getAllStudent();
}
