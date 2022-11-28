package com.jdc.leaves.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.leaves.model.dto.input.LeaveForm;

@Controller
@RequestMapping("/leaves")
public class LeaveController {

	@GetMapping
	public String index(@RequestParam Optional<Integer> classId, @RequestParam Optional<String> studentName,
			@RequestParam Optional<LocalDate> from, @RequestParam Optional<LocalDate> to, ModelMap model) {
		// TODO implement here
		return "leaves";
	}

	@GetMapping("edit")
	public String edit(@RequestParam int classId, @RequestParam int studentId) {
		// TODO implement here
		return "leaves-edit";
	}

	@PostMapping
	public String save(@Valid @ModelAttribute("leavesForm") LeaveForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "leaves-edit";
		}
		return "";
	}

	@ModelAttribute("leavesForm")
	public LeaveForm form(@RequestParam(required = false) Integer classId,
			@RequestParam(required = false) Integer studentId) {

		if (classId != null && studentId != null) {
			return new LeaveForm(classId, studentId);
		}

		return null;

	}

}