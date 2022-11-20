package com.jdc.leaves.model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.leaves.model.dto.input.RegistrationForm;
import com.jdc.leaves.model.dto.output.RegistrationDetailsVO;
import com.jdc.leaves.model.dto.output.RegistrationListVO;

@Service
public class RegistrationService {
	
	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;

	public RegistrationService(DataSource dataSource) {
		
		template = new NamedParameterJdbcTemplate(dataSource);
		
		 insert  = new SimpleJdbcInsert(dataSource);
		 insert.setTableName("registration");
		 insert.setColumnNames(List.of("class_id","student_id","registration_date"));
	}

	public void save(RegistrationForm form) {
		if (form.getId() == 0) {
			insertForm(form);
			return;
		}
		 updateForm(form);
	}

	public RegistrationDetailsVO findDetailsById(int classId, int studentId) {
		// TODO implement here
		return null;
	}

	public RegistrationForm getFormById(int classId, int studentId) {
		return null;
	}

	public List<RegistrationListVO> searchByClassId(int id) {
	
		return null;
	}

	//Update Process
	private void updateForm(RegistrationForm form) {
	//Student Update Process
		final String UPATE_STUDENT ="""
		UPDATE student SET phone =:phone,education =:education
		 WHERE id =:id
				""";
		var params = new HashMap<String,Object>();
		params.put("phone",form.getPhone());
		params.put("education", form.getEducation());
		params.put("id",form.getStudentId());
	    template.update(UPATE_STUDENT,params);
	    
	    
	    //Registration Update Process
	    final String UPDATE_REG = """
	    UPDATE registration SET registration_date =:registration_date
	    WHERE student_id =student_id AND class_id =:class_id		
	    		""";
	    var param = new HashMap<String,Object>();
		 param.put("registration_date",form.getRegistrationDate());
		 param.put("student_id", form.getStudentId());
		 param.put("class_id", form.getClassId());
		 
		 template.update(UPDATE_REG,param);
	}

	//Insert Process
	private void insertForm(RegistrationForm form) {
	
		var student = studentService.findByEmail(form.getEmail());
		
		
		if(null == student) {
		    studentService.createStudent(form);
		}
		
		//Set Student 
		form.setStudentId(student.getId());
		
		
		//Set Registration Date
		if(form.getRegistrationDate() == null) {
			form.setRegistrationDate(LocalDate.now());
		}
		
		var param = new HashMap<String,Object>();
		param.put("studentId", form.getStudentId());
		param.put("class_id", form.getClassId());
		param.put("registration_date",Date.valueOf(form.getRegistrationDate()));
		insert.execute(param);
		
	}
	
}

