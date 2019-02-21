package com.harystolho.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscoverController {

	@GetMapping("/discover")
	public String getDiscoverPage(Model model, HttpServletRequest req) {
		return "discover";
	}
	
}
