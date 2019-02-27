package com.harystolho.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harystolho.dao.CategoryDAO;
import com.harystolho.data.Module;
import com.harystolho.modules.ModuleHandler;
import com.harystolho.modules.impl.NullModuleHandler;
import com.harystolho.utils.Pair;

@Service
public class CategoryService {

	private static final String BASE_MODULES_PACKAGE = "com.harystolho.modules.impl";

	private CategoryDAO categoryDao;

	@Autowired
	public CategoryService(CategoryDAO discoverDao) {
		this.categoryDao = discoverDao;
	}

	public Pair<ServiceError, List<Module>> getModulesFromCategory(String category) {
		// the id in the database
		int category_id = categoryDao.getCategoryId(category);
		List<Module> modules = categoryDao.getModules(category_id);

		if (modules.isEmpty()) {
			return Pair.of(ServiceError.INVALID_CATEGORY_ID, null);
		} else {
			return Pair.of(ServiceError.SUCESS, modules);
		}

	}

	/**
	 * 
	 * @param moduleId
	 * @return the module path relative to {@link #BASE_MODULES_PACKAGE}
	 */
	private String getModuleLocation(int moduleId) {
		return categoryDao.getModulePath(moduleId);
	}

	public ModuleHandler getModuleHandler(int moduleId) {
		try {
			Class<?> cls = Class.forName(BASE_MODULES_PACKAGE + "." + getModuleLocation(moduleId));

			// If the class is instance of ModuleHandler
			if (ModuleHandler.class.isAssignableFrom(cls)) {
				// TODO add cache to class instances
				ModuleHandler handler = (ModuleHandler) cls.getDeclaredConstructor().newInstance();
				return handler;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// return the nullModuleHandler
		}

		return new NullModuleHandler();
	}

}
