package com.jdc.project.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.project.model.dto.Project;
import com.jdc.project.model.service.utils.ProjectHelper;

@Service
public class ProjectService {

	@Autowired
	private ProjectHelper projectHelper;

	@Autowired
	@Qualifier("For Project DB")
	private SimpleJdbcInsert jdbc;

	@Autowired
	@Qualifier("For Jdbc Parameter")
	private NamedParameterJdbcOperations paramJdbc;

	@Value("${service.findById.projects}")
	private String findById;

	@Value("${service.updateById.projects}")
	private String updateById;

	@Value("${service.delete.projects}")
	private String deleteById;

	@Value("${service.search.projects}")
	private String search;
	
	@Value("${service.serarchAll.projects}")
	private String searchAll;

	private BeanPropertyRowMapper<Project> rowMapper;

	public ProjectService() {
		rowMapper = new BeanPropertyRowMapper<Project>(Project.class);
	}

	// Create
	public int create(Project project) {
		projectHelper.validate(project);
		var params = projectHelper.insertParams(project);
		var result = jdbc.executeAndReturnKey(params).intValue();
		return result;
	}

	// Find By Id
	public Project findById(int id) {
		var params = projectHelper.findByIdParams(id);
		var result = paramJdbc.queryForObject(findById, params, rowMapper);

		return result;
	}

	public List<Project> search( String project, String manager, LocalDate dateFrom, LocalDate dateTo) {
		
		  if((project == null || project.isEmpty()) && (manager == null || manager.isEmpty()) && dateFrom == null && dateTo == null) {
			  return paramJdbc.query(searchAll, rowMapper);
		  }
		  
		  if(project != null && (manager == null || manager.isEmpty()) && dateFrom == null && dateTo == null ) {
			  return paramJdbc.query(search,projectHelper.search(project,manager,dateFrom,dateTo), rowMapper);
		  }
		  
		  if((project == null || project.isEmpty()) && manager != null && dateFrom == null && dateTo == null) {
			  return paramJdbc.query(search,projectHelper.search(project,manager,dateFrom,dateTo), rowMapper);
		  }

		  if((project == null || project.isEmpty()) && (manager == null || manager.isEmpty()) && dateFrom != null && dateTo == null) {
			  return paramJdbc.query(search,projectHelper.search(project,manager,dateFrom,dateTo), rowMapper);
		  }
		  
		  if((project == null || project.isEmpty()) && (manager == null || manager.isEmpty()) && dateFrom == null && dateTo != null) {
			  return paramJdbc.query(search,projectHelper.search(project,manager,dateFrom,dateTo), rowMapper);
		  }


		return null;
	}

	// Update
	public int update(int id, String name, String description, LocalDate startDate, int month) {

		var params = projectHelper.updateByIdParams(id, name, description, startDate, month);
		return paramJdbc.update(updateById, params);
	}

	// Delete
	public int deleteById(int id) {

		SqlParameterSource params = projectHelper.deleteParams(id);
		var result = paramJdbc.update(deleteById, params);
		return result;
	}

}
