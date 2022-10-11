package com.jdc.leaves.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.leaves.model.dto.input.TeacherForm;

@Controller
@RequestMapping("teacher")
public class TeacherController {

	@GetMapping
    public String index(@RequestParam Optional<String> name,
    		@RequestParam Optional<String> phone, 
    		@RequestParam Optional<String> email) {
        // TODO implement here
        return "";
    }

	@GetMapping("edit")
    public String edit(Optional<Integer> id) {
        // TODO implement here
        return "";
    }

	@PostMapping
    public String save(TeacherForm form) {
        // TODO implement here
        return "";
    }

}