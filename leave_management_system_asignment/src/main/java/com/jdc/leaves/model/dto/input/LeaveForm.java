package com.jdc.leaves.model.dto.input;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveForm {

    public LeaveForm() {
    }

    private int classId;

    private int studentId;

    private LocalDate applyDate;

    private LocalDate startDate;

    private int days;

    private String reason;

	public LeaveForm(int classId, int studentId, LocalDate applyDate, LocalDate startDate, int days, String reason) {
		super();
		this.classId = classId;
		this.studentId = studentId;
		this.applyDate = applyDate;
		this.startDate = startDate;
		this.days = days;
		this.reason = reason;
	}
	
	public List<Map<String, Object>> leavesDaysInsert() {
		return IntStream.iterate(0, count -> count + 1).limit(days)
			.mapToObj(day -> startDate.plusDays(day))
			.map(this::daysInsertParam)
			.toList();
	}
	
	private Map<String, Object> daysInsertParam(LocalDate leaveDate) {
		return Map.of(
				"leaves_apply_date", Date.valueOf(applyDate),
				"leaves_classes_id", classId,
				"leaves_student_id", studentId,
				"leave_date", leaveDate
		);
	}
	
    
    

}