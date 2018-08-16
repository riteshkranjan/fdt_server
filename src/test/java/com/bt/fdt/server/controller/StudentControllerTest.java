package com.bt.fdt.server.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;

import com.bt.fdt.server.TestBaseController;
import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.service.StudentService;

@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest extends TestBaseController{
	
	@MockBean
	private StudentService service;

	@Test
	public void testGetStudent() throws Exception {
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		s.setStudentId(1);
		when(service.getStudentById(1)).thenReturn(s);
		MvcResult result = mockMvc.perform(get("/student/{id}", 1)).andExpect(status().isOk()).andReturn();
		JSONObject actual = new JSONObject(result.getResponse().getContentAsString());
		JSONObject expected = new JSONObject("{\"studentId\": 1,\"age\": 21,\"studentName\": \"someName\"}");
		JSONAssert.assertEquals(expected, actual, true);
	}

	@Test
	public void testGetAllStudents() throws Exception {
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		s.setStudentId(1);
		List<StudentDto> l = new ArrayList<>();
		l.add(s);
		when(service.getAllStudents()).thenReturn(l);
		MvcResult result = mockMvc.perform(get("/student")).andExpect(status().isOk()).andReturn();
		JSONArray actual = new JSONArray(result.getResponse().getContentAsString());
		Assert.assertEquals(1, actual.length());
		JSONObject expected = new JSONObject("{\"studentId\": 1,\"age\": 21,\"studentName\": \"someName\"}");
		JSONAssert.assertEquals(expected, actual.getJSONObject(0), true);
	}

	@Test
	public void testUpdateStudent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddStudent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteStudent() {
		//fail("Not yet implemented");
	}

}
