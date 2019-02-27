package com.harystolho.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.harystolho.modules.ModuleHandler;

@Service
public class ModuleHandlerService {

	private CategoryService categoryService;
	private Map<String, String> convertedParams;

	@Autowired
	public ModuleHandlerService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Executes the handler for the specified <code>moduleId</code>
	 * 
	 * @param moduleId
	 * @param reqParams
	 * @return
	 */
	public ObjectNode executeModuleHandler(int moduleId, Map<String, String[]> reqParams) {
		ModuleHandler handler = categoryService.getModuleHandler(moduleId);

		convertedParams = convertRequestParams(reqParams);

		return handler.execute(convertedParams);
	}

	/**
	 * Converts the Map(String, String[]) to Map(String, String)
	 * 
	 * @param reqParams
	 * @return
	 */
	private Map<String, String> convertRequestParams(Map<String, String[]> reqParams) {
		Map<String, String> convertedMap = new HashMap<>();

		reqParams.forEach((k, v) -> {
			convertedMap.put(k, v[0]);
		});

		return convertedMap;

	}

}
