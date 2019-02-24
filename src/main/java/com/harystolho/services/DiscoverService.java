package com.harystolho.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harystolho.dao.DiscoverDAO;
import com.harystolho.utils.Pair;

@Service
public class DiscoverService {

	private DiscoverDAO discoverDao;

	@Autowired
	public DiscoverService(DiscoverDAO discoverDao) {
		this.discoverDao = discoverDao;
	}

	public Pair<ServiceError, List<String>> getModulesFromCategory(String category) {
		return Pair.of(ServiceError.INVALID_CATEGORY_ID, Arrays.asList(""));
	}

}
