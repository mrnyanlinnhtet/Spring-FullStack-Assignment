package com.jdc.leaves.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.leaves.model.dto.input.LeaveForm;
import com.jdc.leaves.model.dto.output.LeaveListVO;
import com.jdc.leaves.model.dto.output.LeaveSummaryVO;

@Service
public class LeaveService {
	
	private SimpleJdbcInsert leavesInsert;
	private SimpleJdbcInsert dayInsert;
	private NamedParameterJdbcTemplate template;

    public LeaveService(DataSource dataSource) {
    	
    	template = new NamedParameterJdbcTemplate(dataSource);
    	
    	leavesInsert = new SimpleJdbcInsert(dataSource);
    	leavesInsert.setTableName("leaves");
    	
    	dayInsert = new SimpleJdbcInsert(dataSource);
    	dayInsert.setTableName("leaves_day");
    	
    	
    }

    public List<LeaveListVO> search(Optional<Integer> classId, Optional<String> studentName, Optional<LocalDate> from, Optional<LocalDate> to) {
        // TODO implement here
        return null;
    }

    public LeaveForm findLeaveForClass(int classId,LocalDate date) {
        // TODO implement here
        return null;
    }

    public int save(LeaveForm form) {
        // TODO implement here
        return 0;
    }

    public List<LeaveSummaryVO> searchSummary(Optional<LocalDate> target) {
        // TODO implement here
        return null;
    }

}