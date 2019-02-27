package com.harystolho.modules.impl;

import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.harystolho.modules.InvalidModuleHandler;
import com.harystolho.modules.ModuleHandler;

public class NullModuleHandler implements ModuleHandler{

	@Override
	public ObjectNode execute(Map<String, String> map) {
		return new InvalidModuleHandler();
	}

	@Override
	public boolean areParametersValid(Map<String, String> map) {
		return false;
	}

}
