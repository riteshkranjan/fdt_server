package com.bt.fdt.server.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Hurray!! fdt server is up and running. Access rest api documentation using </br><b>http://localhost:8080/swagger-ui.html#/</b>";

	}

	@RequestMapping("/")
	void handleFoo(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html#/");
	}
}
