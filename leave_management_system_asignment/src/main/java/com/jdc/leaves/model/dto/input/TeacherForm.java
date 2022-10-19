package com.jdc.leaves.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherForm {

    public TeacherForm() {
    }
    

    private int id;

    private String name;

    private String phone;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignDate;

	public TeacherForm(int id, String name, String phone, String email, LocalDate assignDate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.assignDate = assignDate;
	}
    
    

}