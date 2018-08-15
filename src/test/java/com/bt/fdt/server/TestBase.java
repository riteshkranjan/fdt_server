package com.bt.fdt.server;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBase {
	@Rule
	public TestName name = new TestName();

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
