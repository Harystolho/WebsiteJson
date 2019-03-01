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
		reddit_user_posts.setCategoryId(1);
		modules.add(reddit_user_posts);

		Module productHunt_today_products = new Module();
		productHunt_today_products.setName("Product Hunt Today's Products");
		productHunt_today_products.setDescription("List of the today's most popular or newest products");
		productHunt_today_products.addModuleParameter(
				new Module.ModuleParameter("count", "<code>int</code><br>The number of products to retrieve"));
		productHunt_today_products.addModuleParameter(new Module.ModuleParameter("mode",
				"<code>string</code><br><em>popular</em> (Today's most popular products) <br>or<br> <em>newest</em> (Newest products)"));
		productHunt_today_products.setJsonExample("{\"mode\":\"popular\",\"products\":[{\"title\":\"Without Any Capital Book\",\"description\":\"How to bootstrap profitable startups the hacker way\",\"votes\":\"383\",\"link\":\"http://producthunt.com/r/p/146075\",\"category\":\"Productivity\"},{\"title\":\"Spectre\",\"description\":\"Make amazing long exposure shots with the help of AI\",\"votes\":\"343\",\"link\":\"http://producthunt.com/r/p/147225\",\"category\":\"User Experience\"},{\"title\":\"Questo\",\"description\":\"Play a real-world city game on mobile. Backed by Booking.com\",\"votes\":\"343\",\"link\":\"http://producthunt.com/r/p/147211\",\"category\":\"Android\"},{\"title\":\"Avast Passwords for Mac\",\"description\":\"Free password manager from Avast\",\"votes\":\"447\",\"link\":\"http://producthunt.com/r/p/75055?ref=home&promo_id=3008\",\"category\":\"Promoted\"}]}");
		productHunt_today_products.setId(2);
		productHunt_today_products.setCategoryId(2);
		modules.add(productHunt_today_products);

		Module twitter_stats = new Module();
		twitter_stats.setName("Twitter Profile Stats");
		twitter_stats.setDescription("Get information about a twitter profile.");
		twitter_stats.setJsonExample(
				"{\"account\":\"martinfowler\",\"tweets\":7720,\"following\":401,\"followers\":260517,\"likes\":969,\"profileImage\":\"https://pbs.twimg.com/profile_images/79787739/mf-tg-sq_400x400.jpg\",\"profileBio\":\"Programmer, Loud Mouth, ThoughtWorker\"}");
		twitter_stats.addModuleParameter(
				new Module.ModuleParameter("account", "<code>string</code><br>The twitter account username"));
		twitter_stats
				.addModuleParameter(new Module.ModuleParameter("auth", "<code>string</code><br>The authentication id"));
		twitter_stats.setId(4);
		twitter_stats.setCategoryId(3);
		modules.add(twitter_stats);

	}

	public List<Module> getModules(int category_id) {
		List<Module> mdls = new ArrayList<>();

		modules.forEach((mod) -> {
			if (mod.getCategoryId() == category_id)
				mdls.add(mod);
		});

		return mdls;
	}

	@Override
	public Module getModule(int moduleId) {
		for (Module module : modules) {
			if (module.getId() == moduleId)
				return module;
		}
		return null;
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

	@Override
	public String getModulePath(int moduleId) {
		switch (moduleId) {
		case 1:
			return "reddit.";
		case 2:
			return "productHunt.ProductHuntTodayProducts";
		case 3:
			return "producthunt.";
		case 4:
			return "twitter.TwitterProfileInfo";
		default:
			return "NullModuleHandler";
		}
	}

}
