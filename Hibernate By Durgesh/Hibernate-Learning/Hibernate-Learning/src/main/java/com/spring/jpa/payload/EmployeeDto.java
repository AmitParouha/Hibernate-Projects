package com.spring.jpa.payload;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int id;
    private String name;
    private String email;
    private String company;
    private int totalExperienceInMonth;
    private String address;
    private Date joiningDate;
    private byte[] image;

}
