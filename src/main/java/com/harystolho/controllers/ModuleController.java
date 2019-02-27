package com.harystolho.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.harystolho.services.ModuleHandlerService;

@Controller
public class ModuleController {

	private ModuleHandlerService moduleHandlerService;

	@Autowired
	public ModuleController(ModuleHandlerService moduleHandlerService) {
		this.moduleHandlerService = moduleHandlerService;
	}

	@ResponseBody
	@PostMapping(path = "/module/{moduleId}", produces = "application/json")
	public ObjectNode handleModuleRequest(@PathVariable int moduleId, HttpServletRequest req) {
		return moduleHandlerService.executeModuleHandler(moduleId, req.getParameterMap());
	}

}
