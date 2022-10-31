package com.jdc.leaves.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassForm {

    public ClassForm() {
    }

    private int id;

    private int teacher;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate start;

    private int months;

    private String description;
    
    
    
    

}