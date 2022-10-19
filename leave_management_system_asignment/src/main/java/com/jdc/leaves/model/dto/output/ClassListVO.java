package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassListVO {

    public ClassListVO() {
    }

    private int id;

    private int teacherId;

    private String teacherName;

    private String teacherPhone;

    private LocalDate startDate;

    private int months;

    private String description;

    private long studentCount;

}