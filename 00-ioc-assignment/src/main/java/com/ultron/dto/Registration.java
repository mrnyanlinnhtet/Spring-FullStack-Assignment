package com.ultron.dto;

public class Registration {

	private int id;
	private OpenClass openClass;
	private String student;
	private String email;
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OpenClass getOpenClass() {
		return openClass;
	}

	public void setOpenClass(OpenClass openClass) {
		this.openClass = openClass;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
