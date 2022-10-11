package com.jdc.leaves.model.dto.input;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveForm {

    public LeaveForm() {
    }

    private int classId;

    private int student;

    private LocalDate applyDate;

    private LocalDate startDate;

    private int days;

    private String reason;

}