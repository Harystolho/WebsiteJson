package com.harystolho.modules;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class InvalidParameters extends ObjectNode {

	private InvalidParameters(JsonNodeFactory nc) {
		super(nc);
	}

	public InvalidParameters() {
		super(new JsonNodeFactory(false));

		put("error", "INVALID_PARAMETERS");
		put("errorMessage",
				"The parameters provided for the specified handler are not valid. Please check the module documentation");
	}

}
