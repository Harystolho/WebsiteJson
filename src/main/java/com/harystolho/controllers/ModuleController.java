package com.harystolho.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModuleController {

	@ResponseBody
	@GetMapping(path = "/module/{id}", produces = "application/json")
	public String handleModuleRequest(@PathVariable int id, HttpServletRequest req) {
		return "{}";
	}
	
}
