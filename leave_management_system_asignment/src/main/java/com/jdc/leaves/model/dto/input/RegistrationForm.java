package com.jdc.leaves.model.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationForm {

	public RegistrationForm() {
	}

	private int id;
	private int classId;

	private int studentId;

	private String studentName;

	private String email;

	private String phone;

	private String education;

}