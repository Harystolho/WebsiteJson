package com.harystolho.modules.impl.twitter;

import java.net.URL;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.harystolho.modules.InvalidParameters;
import com.harystolho.modules.ModuleHandler;

public class TwitterProfileInfo implements ModuleHandler {

	@Override
	public ObjectNode execute(Map<String, String> map) {
		if (!areParametersValid(map))
			return new InvalidParameters();

		ObjectNode response = createDefaultObject();

		Document profilePage = getProfilePage(map.get("account"));

		if (profilePage == null) {
			response.put("error", "Can't connect to twitter's page");
			return response;
		}

		response.put("account", map.get("account"));
		response.put("tweets", getTweetsCount(profilePage));
		response.put("following", getFollowingCount(profilePage));
		response.put("followers", getFollowersCount(profilePage));
		response.put("likes", getLikesCount(profilePage));
		response.put("profileImage", getProfileImageURL(profilePage));
		response.put("profileBio", getProfileBio(profilePage));

		return response;
	}

	private int getTweetsCount(Document profilePage) {
		return extractValueFromProfileNav(profilePage, "ProfileNav-item--tweets");
	}

	private int getFollowingCount(Document profilePage) {
		return extractValueFromProfileNav(profilePage, "ProfileNav-item--following");
	}

	private int getFollowersCount(Document profilePage) {
		return extractValueFromProfileNav(profilePage, "ProfileNav-item--followers");
	}

	private int getLikesCount(Document profilePage) {
		return extractValueFromProfileNav(profilePage, "ProfileNav-item--favorites");
	}

	private String getProfileImageURL(Document profilePage) {
		return profilePage.getElementsByClass("ProfileAvatar-image").get(0).attr("src");
	}

	private String getProfileBio(Document profilePage) {
		return profilePage.getElementsByClass("ProfileHeaderCard-bio").get(0).text();
	}

	private int extractValueFromProfileNav(Document profilePage, String navClass) {
		try {
			Element tweetsContainer = profilePage.getElementsByClass(navClass).get(0);
			return Integer.parseInt(tweetsContainer.getElementsByClass("ProfileNav-value").get(0).attr("data-count"));
		} catch (Exception e) {
			return -1;
		}
	}

	private Document getProfilePage(String account) {
		try {
			return Jsoup.parse(new URL("http://twitter.com/" + account), 2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean areParametersValid(Map<String, String> map) {
		return map.containsKey("account");
	}

}
