package com.jdc.leaves.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.leaves.model.dto.input.RegistrationForm;
import com.jdc.leaves.model.dto.output.RegistrationDetailsVO;
import com.jdc.leaves.model.dto.output.RegistrationListVO;

@Service
public class RegistrationService {

    public RegistrationService() {
    }

    public int save(RegistrationForm form) {
        // TODO implement here
        return 0;
    }

    
    public RegistrationDetailsVO findDetailsById(int classId, int studentId) {
        // TODO implement here
        return null;
    }

    public RegistrationForm getFormById(int classId, int studentId) {
        // TODO implement here
        return null;
    }

    public List<RegistrationListVO> searchByClassId(int id) {
        // TODO implement here
        return null;
    }

}