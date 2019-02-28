package com.harystolho.data;

public class Module {

	private int id;
	private String name;

	// HTML
	private String description;
	
	// JSON (an example of a JSON response from this module)
	private String jsonExample;

	private int category_id;

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
}
