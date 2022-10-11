package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherListVO {

    public TeacherListVO() {
    }

    private int id;

    private String name;

    private String phone;

    private String email;

    private LocalDate assignDate;

    private long classCount;

}