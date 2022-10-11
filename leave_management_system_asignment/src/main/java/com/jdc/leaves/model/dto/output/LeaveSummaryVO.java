package com.jdc.leaves.model.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveSummaryVO {

    public LeaveSummaryVO() {
    }

    private int classId;

    private String teacher;

    private String startDate;

    private long students;

    private long leaves;

}