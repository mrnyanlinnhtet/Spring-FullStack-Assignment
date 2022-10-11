package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveListVO {

    public LeaveListVO() {
    }

    private LocalDate applyDate;

    private int classId;

    private int studentId;

    private String student;

    private String studentPhone;

    private int teacherId;

    private String teacher;

    private LocalDate startDate;

    private int days;

    private String reason;

}