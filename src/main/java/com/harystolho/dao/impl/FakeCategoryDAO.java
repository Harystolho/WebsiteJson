package com.harystolho.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harystolho.dao.CategoryDAO;
import com.harystolho.data.Module;

@Service
public class FakeCategoryDAO implements CategoryDAO {

	List<Module> modules;

	public FakeCategoryDAO() {
		modules = new ArrayList<>();

		Module reddit_user_posts = new Module();
		reddit_user_posts.setName("Reddit User Posts");
		reddit_user_posts.setDescription("Some random information that goes here");
		reddit_user_posts.setId(1);
		reddit_user_posts.setCategory_id(1);
		modules.add(reddit_user_posts);

		Module productHunt_posts = new Module();
		productHunt_posts.setName("Product Hunt posts");
		productHunt_posts.setDescription("Some random information that goes here");
		productHunt_posts.setId(2);
		productHunt_posts.setCategory_id(2);
		modules.add(productHunt_posts);

		Module productHunt_comments = new Module();
		productHunt_comments.setName("Product Hunt comments");
		productHunt_comments.setDescription("Some random information that goes here");
		productHunt_comments.setId(3);
		productHunt_comments.setCategory_id(2);
		modules.add(productHunt_comments);

		Module twitter_stats = new Module();
		twitter_stats.setName("Twitter Profile Stats");
		twitter_stats.setDescription("Get information about a twitter profile.");
		twitter_stats.setId(4);
		twitter_stats.setCategory_id(3);
		modules.add(twitter_stats);
		
	}

	public List<Module> getModules(int category_id) {
		List<Module> mdls = new ArrayList<>();

		modules.forEach((mod) -> {
			if (mod.getCategory_id() == category_id)
				mdls.add(mod);
		});

		return mdls;
	}

	@Override
	public int getCategoryId(String category) {
		switch (category) {
		case "REDDIT":
			return 1;
		case "PRODUCT_HUNT":
			return 2;
		case "TWITTER":
			return 3;
		default:
			return -1;
		}
	}

}

