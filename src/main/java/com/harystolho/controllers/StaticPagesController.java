package com.harystolho.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPagesController {

	@GetMapping("/tests")
	public String getTestPage(Model model, HttpServletRequest req) {
		return "tests";
	}

	@GetMapping("/temp")
	public void temporaryMethod(HttpServletResponse res) {
		try {
			Document parse = Jsoup.parse(new URL("https://www.producthunt.com/"), 5000);
			res.getWriter().print(parse.outerHtml());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
