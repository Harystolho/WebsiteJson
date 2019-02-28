package com.harystolho.modules.impl.twitter;

import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.harystolho.modules.InvalidParameters;
import com.harystolho.modules.ModuleHandler;

public class TwitterProfileInfo implements ModuleHandler {

	@Override
	public ObjectNode execute(Map<String, String> map) {
		if (!areParametersValid(map))
			return new InvalidParameters();

		ObjectNode response = createDefaultObject();

		response.put("account", map.get("account"));

		return response;
	}

	@Override
	public boolean areParametersValid(Map<String, String> map) {
		return map.containsKey("account");
	}

}
