package com.jdc.leaves.model.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentListVO {

    public StudentListVO() {
    }

    private int id;

    private String name;

    private String phone;

    private String email;

    private String education;

    private long classCount;

}