package com.codoverse.url;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api")
public class RequestParamController {
	
	@GetMapping("date/lt")
	public String handleLocalTime(Model model, LocalTime ltVal) {
		return addAndReturn(model, ltVal);
	}
	
	@GetMapping("date/ym")
	public String handleYearMonth(Model model, YearMonth ymVal) {
		return addAndReturn(model, ymVal);
	}
	
	@GetMapping("date/util")
	public String handleUtilDate(Model model, @DateTimeFormat(pattern = "yyyy-MM-dd") Date udVal) {
		return addAndReturn(model, udVal);
	}
	
	@GetMapping("date/ld")
	public String handleLocalDate(Model model, @DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate ldVal) {
		return addAndReturn(model, ldVal);
	}
	
	@GetMapping("enum")
	public String handleEnum(Model model, Status statusVal) {
		return addAndReturn(model, statusVal);
	}
	
	@GetMapping("string")
	public String handleString(Model model, @RequestParam String strVal) {
		return addAndReturn(model, strVal);
	}
	
	@GetMapping("integer")
	public String handleInteger(Model model, Integer intVal) {
		return addAndReturn(model, intVal);
	}
	
	@GetMapping("float")
	public String handleFloat(Model model, Float floatVal) {
		return addAndReturn(model, floatVal);
	}
	
	@GetMapping("user")
	public String handleBoolean(Model model, User user) {
		return addAndReturn(model, user);
	}
	
	private String addAndReturn(Model model, Object obj) {
		model.addAttribute("value", obj);
		return "index";
	}

}
