package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;

import com.jdc.leaves.model.dto.input.TeacherForm;

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

	public TeacherForm teacherForm() {
		return new TeacherForm(id, name, phone, email, assignDate);
	}

}