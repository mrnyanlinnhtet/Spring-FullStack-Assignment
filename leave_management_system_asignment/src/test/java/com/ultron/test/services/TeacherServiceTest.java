package com.ultron.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.leaves.model.dto.input.TeacherForm;
import com.jdc.leaves.model.service.TeacherService;

@SpringJUnitConfig(locations = "/root-config.xml")
@Sql(scripts = "/sql/truncate_db.sql")
public class TeacherServiceTest {

	@Autowired
	private TeacherService service;

	@ParameterizedTest
	@CsvSource(value = "0,Min Lwin,09223453,lwinmin@gmail.com,2022-09-09")
	void save_insert_success(int id, String name, String phone, String email, LocalDate assignDate) {
		var form = new TeacherForm(id, name, phone, email, assignDate);
		var result = service.save(form);
		assertEquals(1, result);
	}

}
