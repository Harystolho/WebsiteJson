package com.harystolho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harystolho.dao.DiscoverDAO;

@Service
public class DiscoverService {

	private DiscoverDAO discoverDao;

	@Autowired
	public DiscoverService(DiscoverDAO discoverDao) {
		this.discoverDao = discoverDao;
	}

}
