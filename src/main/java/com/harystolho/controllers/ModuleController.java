package com.harystolho.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harystolho.services.CategoryService;

@Controller
public class ModuleController {

	private CategoryService categoryService;

	@Autowired
	public ModuleController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ResponseBody
	@GetMapping(path = "/module/{id}", produces = "application/json")
	public String handleModuleRequest(@PathVariable int id, HttpServletRequest req) {
		return "{}";
	}

}
