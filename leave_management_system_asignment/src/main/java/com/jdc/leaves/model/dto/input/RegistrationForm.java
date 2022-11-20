package com.jdc.leaves.model.dto.input;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class RegistrationForm {

	public RegistrationForm() {
	}
	
	

	public RegistrationForm(int classId, LocalDate registrationDate, int studentId, String studentName, String email,
			String phone, String education) {
		super();
		this.classId = classId;
		this.registrationDate = registrationDate;
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.phone = phone;
		this.education = education;
	}



	private int id;
	private int classId;
	private LocalDate registrationDate;

	private int studentId;

	private String studentName;

	private String email;

	private String phone;

	private String education;

}