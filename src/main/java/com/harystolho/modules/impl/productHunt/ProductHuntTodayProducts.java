package com.harystolho.modules.impl.productHunt;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.harystolho.modules.InvalidParameters;
import com.harystolho.modules.ModuleHandler;

public class ProductHuntTodayProducts implements ModuleHandler {

	@Override
	public ObjectNode execute(Map<String, String> map) {
		if (!areParametersValid(map))
			return new InvalidParameters();

		ObjectNode response = createDefaultObject();

		Document productsPage = getProductsPage(map.get("mode"));

		if (productsPage == null) {
			response.put("error", "Can't connect to product hunt's page");
			return response;
		}

		response.put("mode", map.get("mode"));
		response.set("products", extractProducts(productsPage));

		return response;
	}

	private ArrayNode extractProducts(Document productsPage) {
		ArrayNode productsJson = new ArrayNode(new JsonNodeFactory(false));

		Element productsContainer = null;

		if (productsPage.getElementsByClass("postsList_b2208").get(0).childNodeSize() > 3) {
			productsContainer = productsPage.getElementsByClass("postsList_b2208").get(0);
		} else {
			productsContainer = productsPage.getElementsByClass("postsList_b2208").get(1);
		}

		Elements products = productsContainer.getElementsByClass("item_54fdd");

		products.forEach((prod) -> {
			ObjectNode prodJson = createDefaultObject();

			prodJson.put("title", prod.getElementsByClass("font_9d927").get(0).text());
			prodJson.put("description", prod.getElementsByClass("font_9d927").get(1).text());
			prodJson.put("votes", prod.getElementsByClass("font_9d927").get(2).child(1).text());
			prodJson.put("link",
					"http://producthunt.com" + prod.getElementsByClass("font_9d927").get(5).parent().attr("href"));
			prodJson.put("category", prod.getElementsByClass("font_9d927").get(6).text());

			productsJson.add(prodJson);
		});

		return productsJson;
	}

	private Document getProductsPage(String mode) {
		try {
			return Jsoup.parse(new URL("https://www.producthunt.com/"), 3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean areParametersValid(Map<String, String> map) {
		return map.containsKey("mode") && (map.get("mode").equals("popular") || map.get("mode").equals("newest"));
	}

}
