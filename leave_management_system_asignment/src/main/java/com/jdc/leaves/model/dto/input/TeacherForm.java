package com.jdc.leaves.model.dto.input;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherForm {

    public TeacherForm() {
    }

    private int id;

    private String name;

    private String phone;

    private String email;

    private LocalDate assignDate;

}