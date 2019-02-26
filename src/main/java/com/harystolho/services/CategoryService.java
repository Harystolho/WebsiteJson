package com.harystolho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harystolho.dao.CategoryDAO;
import com.harystolho.data.Module;
import com.harystolho.utils.Pair;

@Service
public class CategoryService {

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

}
