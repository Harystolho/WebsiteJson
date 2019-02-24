package com.harystolho.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harystolho.services.DiscoverService;
import com.harystolho.services.ServiceError;
import com.harystolho.utils.Pair;

@Controller
public class DiscoverController {

	private DiscoverService discoverService;

	@Autowired
	public DiscoverController(DiscoverService discoverService) {
		this.discoverService = discoverService;
		
	}
	
	@GetMapping("/discover")
	public String getDiscoverPage(Model model, HttpServletRequest req) {
		return "discover";
	}
	
	@ResponseBody
	@GetMapping("/api/category")
	public String getModulesFromCategory(@RequestParam(name = "category") String category) {
		Pair<ServiceError, List<String>> reponse = discoverService.getModulesFromCategory(category);
		
		switch (reponse.getFirst()) {
		case INVALID_CATEGORY_ID:
			
			break;

		default:
			break;
		}
		
		return "";
	}
	
}
