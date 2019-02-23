package com.harystolho.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harystolho.services.DiscoverService;

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
	public String getCategories(@RequestParam(name = "category") String category) {
		System.out.println(category);
		return "";
	}
	
}
