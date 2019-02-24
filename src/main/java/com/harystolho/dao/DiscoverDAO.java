package com.harystolho.dao;

import java.util.List;

import com.harystolho.data.Module;

public interface DiscoverDAO {

	public List<Module> getModules(int category_id);

	/**
	 * @param category
	 * @return the database id for the category
	 */
	public int getCategoryId(String category);

}
