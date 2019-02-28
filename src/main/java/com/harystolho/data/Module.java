package com.harystolho.data;

import java.util.ArrayList;
import java.util.List;

public class Module {

	private int id;
	private String name;

	// HTML
	private String description;

	// JSON (an example of a JSON response from this module)
	private String jsonExample;

	private List<ModuleParameter> usageParams;

	private int category_id;

	public Module() {
		this.usageParams = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return category_id;
	}

	public void setCategoryId(int category_id) {
		this.category_id = category_id;
	}

	public String getJsonExample() {
		return jsonExample;
	}

	public void setJsonExample(String jsonExemple) {
		this.jsonExample = jsonExemple;
	}

	public List<ModuleParameter> getUsageParams() {
		return usageParams;
	}

	public void addModuleParameter(ModuleParameter mp) {
		this.usageParams.add(mp);
	}

	public static class ModuleParameter {
		// HTML or String
		private String name;

		// HTML
		private String info;

		public ModuleParameter() {
		}

		public ModuleParameter(String name, String info) {
			this.name = name;
			this.info = info;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}
}
