package com.bt.fdt.server.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MvcResult;

import com.bt.fdt.server.TestBaseController;

@WebMvcTest(value = WelcomeController.class, secure = false)
public class WelcomeControllerTest extends TestBaseController{

	@Test
	public void testWelcome() throws Exception {
		MvcResult result = mockMvc.perform(get("/")).andExpect(status().isOk()).andReturn();
		Assert.assertTrue(result.getResponse().getContentAsString().equals("Hurray!! fdt server is up and running"));
	}

}
