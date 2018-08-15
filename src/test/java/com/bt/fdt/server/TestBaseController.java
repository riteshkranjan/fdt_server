package com.bt.fdt.server;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
public class TestBaseController {
	@Rule
	public TestName name = new TestName();

	@Autowired
	protected MockMvc mockMvc;
	
	@Before
	public void before() {
		System.out.println(String.format("Running Test %s : %s", super.getClass(), name.getMethodName()));
	}

	@Ignore
	@Test
	public void contextLoads() {
		System.out.println("Context loaded successFully");
	}

}
