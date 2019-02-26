package com.harystolho.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harystolho.API_Response;
import com.harystolho.data.Module;
import com.harystolho.services.CategoryService;
import com.harystolho.services.ServiceError;
import com.harystolho.utils.Pair;

@Controller
public class DiscoverController {

	private CategoryService categoryService;

	@Autowired
	public DiscoverController(CategoryService categoryService) {
		this.categoryService = categoryService;

	}

	@GetMapping("/discover")
	public String getDiscoverPage(Model model, HttpServletRequest req) {
		return "discover";
	}

	@ResponseBody
	@GetMapping("/api/category")
	public API_Response getModulesFromCategory(@RequestParam(name = "category") String category) {
		Pair<ServiceError, List<Module>> reponse = categoryService.getModulesFromCategory(category);

		API_Response apiResponse = new API_Response();

		switch (reponse.getFirst()) {
		case INVALID_CATEGORY_ID:
			apiResponse.setError("INVALID_CATEGORY");
			return apiResponse;
		default:
			break;
		}

		apiResponse.setError(API_Response.ERROR_NONE);
		apiResponse.setData(reponse.getSecond());

		return apiResponse;
	}

}
