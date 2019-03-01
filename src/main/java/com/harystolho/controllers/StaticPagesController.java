package com.harystolho.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			URL url = new URL("https://twitter.com/harystolho/");
			URLConnection conn = url.openConnection();

			conn.connect();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			for (String line; (line = br.readLine()) != null;) {
				res.getWriter().append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
