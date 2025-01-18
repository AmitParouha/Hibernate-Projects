package com.spring.jpa.payload;

import com.spring.jpa.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private int id;
    private String name;
    private Course course;

}
