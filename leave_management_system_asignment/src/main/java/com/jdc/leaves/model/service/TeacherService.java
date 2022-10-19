package com.jdc.leaves.model.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.leaves.model.dto.input.TeacherForm;
import com.jdc.leaves.model.dto.output.IdWithName;
import com.jdc.leaves.model.dto.output.TeacherListVO;

@Service
public class TeacherService {

	private NamedParameterJdbcTemplate namedJdbc;
	private SimpleJdbcInsert accountInsert;
	private SimpleJdbcInsert teacherInsert;

	// TODO : set configuration for password encoder bean
	@Autowired
	private PasswordEncoder encoder;

	// TODO : set configuration for dataSource bean
	public TeacherService(DataSource dataSource) {
		namedJdbc = new NamedParameterJdbcTemplate(dataSource);

		// For Account Table
		accountInsert = new SimpleJdbcInsert(dataSource);
		accountInsert.setTableName("account");
		accountInsert.setCatalogName("id");

		// For Teacher Table
		teacherInsert = new SimpleJdbcInsert(dataSource);
		teacherInsert.setTableName("teacher");
	}

	public int save(TeacherForm form) {
		if (form.getId() == 0) {
			return insert(form);
		}
		return edit(form);
	}

	public List<TeacherListVO> search(Optional<String> name, Optional<String> phone, Optional<String> email) {
		// TODO implement here
		return null;
	}

	public TeacherListVO findById(int id) {
		// TODO implement here
		return null;
	}

	public List<IdWithName> getAvailableTeachers() {
		// TODO implement here
		return null;
	}

	// Insert Form
	private int insert(TeacherForm form) {
		// Insert To Account
		var paramsForAccount = new HashMap<String, Object>();
		paramsForAccount.put("name", form.getName());
		paramsForAccount.put("role", "TEACHER");
		paramsForAccount.put("email", form.getEmail());
		paramsForAccount.put("password", encoder.encode(form.getPhone()));
		var account = accountInsert.executeAndReturnKey(paramsForAccount);

		// Insert To Teacher
		var paramsForTeacher = new HashMap<String, Object>();
		paramsForTeacher.put("id", account.intValue());
		paramsForTeacher.put("phone", form.getPhone());
		paramsForTeacher.put("assign_date", Date.valueOf(form.getAssignDate()));
		teacherInsert.execute(paramsForTeacher);
		return account.intValue();
	}

	// Edit Form
	private int edit(TeacherForm form) {
		// Update For Account
		final String UPDATE_ACCOUNT = "UPDATE account SET name=:name WHERE id =:id";
		var paramsForAccount = new HashMap<String, Object>();
		paramsForAccount.put("name", form.getName());
		paramsForAccount.put("id", form.getId());
		namedJdbc.update(UPDATE_ACCOUNT, paramsForAccount);

		// Update For Teacher
		final String UPDATE_TEACHER = "UPDATE teacher SET phone=:phone,assign_date=:assign_date WHERE id=:id";
		var paramsForTeacher = new HashMap<String, Object>();
		paramsForTeacher.put("phone", form.getPhone());
		paramsForTeacher.put("assign_date", Date.valueOf(form.getAssignDate()));
		paramsForTeacher.put("id", form.getId());
		namedJdbc.update(UPDATE_TEACHER, paramsForTeacher);

		return form.getId();
	}

}