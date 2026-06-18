package com.codoverse.url;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("path")
public class PathVariableController {
	
	@GetMapping("int/{intVal:\\-?\\d+}")
	public String handleInteger(Model model, @PathVariable("intVal") Integer integer) {
		return addAndReturn(model, integer);
	}
	
	@GetMapping("string/{strVal:0?97[1-9]\\d{7}}")
	public String handleString(Model model, @PathVariable String strVal) {
		return addAndReturn(model, strVal);
	}
	
	@GetMapping("enum/{statusVal:Pending|Completed|Canceled}")
	public String handleEnum(Model model, @PathVariable Status statusVal) {
		return addAndReturn(model, statusVal);
	}
	
	private String addAndReturn(Model model, Object obj) {
		model.addAttribute("value", obj);
		return "index";
	}

}
