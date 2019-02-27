package com.harystolho.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.harystolho.modules.ModuleHandler;
import com.harystolho.services.CategoryService;

@Controller
public class ModuleController {

	private CategoryService categoryService;

	@Autowired
	public ModuleController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ResponseBody
	@PostMapping(path = "/module/{moduleId}", produces = "application/json")
	public ObjectNode handleModuleRequest(@PathVariable int moduleId, HttpServletRequest req) {
		ModuleHandler handler = categoryService.getModuleHandler(moduleId);
		return handler.execute(req.getParameterMap());
	}

}
