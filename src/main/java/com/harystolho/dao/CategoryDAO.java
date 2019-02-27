package com.harystolho.dao;

import java.util.List;

import com.harystolho.data.Module;
import com.harystolho.services.CategoryService;

public interface CategoryDAO {

	public List<Module> getModules(int category_id);

	/**
	 * @param category
	 * @return the database id for the category
	 */
	public int getCategoryId(String category);

	/**
	 * Returns the module path relative to the base implementation package.
	 * 
	 * @param moduleId
	 * @return
	 * 
	 * @see {@link CategoryService#BASE_MODULES_PACKAGE}
	 */
	public String getModulePath(int moduleId);

}
