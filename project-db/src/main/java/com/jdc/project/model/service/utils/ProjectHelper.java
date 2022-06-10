package com.jdc.project.model.service.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.jdc.project.model.ProjectDbException;
import com.jdc.project.model.dto.Project;

@Component
public class ProjectHelper {

	@Value("${project.empty.name}")
	private String noName;
	@Value("${project.empty.manager}")
	private String noManager;
	@Value("${project.empty.start}")
	private String noStartDate;

	public void validate(Project dto) {

		if (dto.getName() == null || dto.getName().isEmpty()) {
			throw new ProjectDbException(noName);
		}

		if (dto.getManagerId() == 0) {
			throw new ProjectDbException(noManager);
		}

		if (dto.getStartDate() == null) {
			throw new ProjectDbException(noStartDate);
		}
	}

	public Map<String, Object> insertParams(Project dto) {
		var map = new HashMap<String, Object>();
		map.put("name", dto.getName());
		map.put("description", dto.getDescription());
		map.put("manager", dto.getManagerId());
		map.put("start", Date.valueOf(dto.getStartDate()));
		map.put("months", dto.getMonths());

		return map;
	}

	public SqlParameterSource findByIdParams(int id) {

		var param = new MapSqlParameterSource();
		param.addValue("id", id);
		return param;
	}

	public SqlParameterSource updateByIdParams(int id, String name, String description, LocalDate startDate,
			int month) {

		var params = new MapSqlParameterSource();
		params.addValue("name", name);
		params.addValue("description", description);
		params.addValue("startDate", startDate);
		params.addValue("months", month);
		params.addValue("id", id);
		return params;
	}

	public SqlParameterSource deleteParams(int id) {

		var params = new MapSqlParameterSource();
		params.addValue("id", id);
		return params;
	}

	public SqlParameterSource search(String project,String manager,LocalDate dateFrom,LocalDate dateTo) {

		var params = new MapSqlParameterSource();
		params.addValue("projectName", project != null? project.toLowerCase().concat("%"):project);
		params.addValue("managerName", manager != null? manager.toLowerCase().concat("%"):manager);
		params.addValue("dateFrom", dateFrom);
		params.addValue("dateTo", dateTo);
		return params;
	}
	
	
}
