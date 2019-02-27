package com.harystolho.modules;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class InvalidModuleHandler extends ObjectNode {

	private InvalidModuleHandler(JsonNodeFactory nc) {
		super(nc);
	}

	public InvalidModuleHandler() {
		super(new JsonNodeFactory(false));

		put("error", "INVALID_HANDLER");
		put("errorMessage",
				"The module with the specified id was not found.");
	}

}
