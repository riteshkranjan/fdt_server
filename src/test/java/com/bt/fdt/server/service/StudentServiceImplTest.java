package com.bt.fdt.server.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bt.fdt.server.TestBase;
import com.bt.fdt.server.component.StudentComponent;
import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.exception.FDTException;

public class StudentServiceImplTest extends TestBase {
	private boolean mockInitialized = false;

	@Mock
	StudentComponent comp;

	@InjectMocks
	StudentServiceImpl impl;

	@Before
	public void setup() throws Exception {
		if (!mockInitialized) {
			MockitoAnnotations.initMocks(this);
			mockInitialized = true;
		}
	}

	@Test
	public void testGetStudentById() {
		when(comp.getStudentById(1)).thenReturn(null);
		Assert.assertNull(impl.getStudentById(1));
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		s.setStudentId(1);
		when(comp.getStudentById(1)).thenReturn(s);
		Assert.assertNotNull(impl.getStudentById(1));
		Assert.assertEquals(1, s.getStudentId());
		Assert.assertEquals("someName", s.getStudentName());
		Assert.assertEquals(21, s.getAge().intValue());
	}

	@Test
	public void testGetAllStudents() {
		List<StudentDto> students = new ArrayList<>();
		when(comp.getAllStudents()).thenReturn(students);
		Assert.assertEquals(0, impl.getAllStudents().size());
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		s.setStudentId(1);
		students.add(s);
		when(comp.getAllStudents()).thenReturn(students);
		Assert.assertEquals(1, impl.getAllStudents().size());
	}

	@Test
	public void testAddStudent() throws FDTException {
		when(comp.addStudent(any(StudentDto.class))).thenReturn(1L);
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		s.setStudentId(1);
		Assert.assertEquals(1, impl.addStudent(s));
	}

	@Test(expected = FDTException.class)
	public void testAddStudentWithNullName() throws FDTException {
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentId(1);
		impl.addStudent(s);
	}
	
	@Test(expected = FDTException.class)
	public void testAddStudentWithEmptyName() throws FDTException {
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentId(1);
		s.setStudentName("");
		impl.addStudent(s);
	}

	@Test
	public void testRemoveStudent() {
		doNothing().when(comp).removeStudent(1L);
		impl.removeStudent(1);
	}

	@Test
	public void testUpdateStudent() throws FDTException {
		doNothing().when(comp).updateStudent(any(StudentDto.class));
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		s.setStudentId(1);
		impl.updateStudent(s);
	}

	@Test(expected = FDTException.class)
	public void testFailUpdateWhenStudentIsNull() throws FDTException {
		impl.updateStudent(null);
	}

	@Test(expected = FDTException.class)
	public void testFailUpdateWhenIdIsNotPresent() throws FDTException {
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		s.setStudentId(0);
		impl.updateStudent(s);
	}

}
