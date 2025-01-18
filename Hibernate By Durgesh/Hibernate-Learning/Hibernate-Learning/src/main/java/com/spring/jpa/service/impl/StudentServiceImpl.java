package com.spring.jpa.service.impl;

import com.spring.jpa.entity.Student;
import com.spring.jpa.payload.StudentDto;
import com.spring.jpa.repository.StudentRepository;
import com.spring.jpa.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private ModelMapper mapper;
    private StudentRepository studentRepository;

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = studentRepository.save(mapToStudent(studentDto));
        return mapToStudentDto(student);
    }

    @Override
    public StudentDto getStudent(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        return mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map(student -> mapToStudentDto(student)).collect(Collectors.toList());

        return studentDtos;
    }

    public Student mapToStudent(StudentDto studentDto){
        return mapper.map(studentDto, Student.class);
    }

    public StudentDto mapToStudentDto(Student student){
        return mapper.map(student, StudentDto.class);
    }
}
