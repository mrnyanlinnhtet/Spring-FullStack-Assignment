package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationListVO {

    public RegistrationListVO() {
    }

    private int id;

    private int classId;

    private int teacherId;

    private String teacher;

    private LocalDate startDate;

    private int studentId;

    private String student;

    private String studentPhone;

    private LocalDate registrationDate;
    
    

}