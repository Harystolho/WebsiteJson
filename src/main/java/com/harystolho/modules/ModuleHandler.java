package com.harystolho.modules;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface ModuleHandler {

	/**
	 * 
	 * @param map the same map returned by
	 *            {@link HttpServletRequest#getParameterMap()}
	 * @return an {@link ObjectNode} that has the fields specified in the handler
	 *         documentation
	 */
	public ObjectNode execute(Map<String, String> map);

	public boolean areParametersValid(Map<String, String> map);

}
