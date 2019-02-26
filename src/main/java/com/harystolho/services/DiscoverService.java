package com.harystolho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harystolho.dao.DiscoverDAO;
import com.harystolho.data.Module;
import com.harystolho.utils.Pair;

@Service
public class DiscoverService {

	private DiscoverDAO discoverDao;

	@Autowired
	public DiscoverService(DiscoverDAO discoverDao) {
		this.discoverDao = discoverDao;
	}

	public Pair<ServiceError, List<Module>> getModulesFromCategory(String category) {
		// the id in the database
		int category_id = discoverDao.getCategoryId(category);
		List<Module> modules = discoverDao.getModules(category_id);

		if (modules.isEmpty()) {
			return Pair.of(ServiceError.INVALID_CATEGORY_ID, null);
		} else {
			return Pair.of(ServiceError.SUCESS, modules);
		}

	}

}
