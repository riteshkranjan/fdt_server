package com.bt.fdt.server.component;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bt.fdt.server.TestBase;
import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.exception.FDTException;

public class StudentComponentImplTest extends TestBase {

	@Autowired
	StudentComponent comp;

	@Test
	public void testGetStudentById() {
		StudentDto s = comp.getStudentById(1);
		Assert.assertNull(s);
		
		long id = createSampleStudent();
		s = comp.getStudentById(id);
		Assert.assertNotNull(s);
		Assert.assertEquals(id, s.getStudentId());
		Assert.assertEquals("someName", s.getStudentName());
		Assert.assertEquals(21, s.getAge().intValue());
		deleteSampleStudent(id);
	}

	@Test
	public void testGetAllStudents() {
		List<StudentDto> allStudents = comp.getAllStudents();
		Assert.assertEquals(0, allStudents.size());
		long id = createSampleStudent();
		long id2 = createSampleStudent();
		allStudents = comp.getAllStudents();
		Assert.assertEquals(2, allStudents.size());
		StudentDto s = allStudents.get(0);
		Assert.assertEquals(id, s.getStudentId());
		Assert.assertEquals("someName", s.getStudentName());
		Assert.assertEquals(21, s.getAge().intValue());
		
		s = allStudents.get(1);
		Assert.assertEquals(id2, s.getStudentId());
		Assert.assertEquals("someName", s.getStudentName());
		Assert.assertEquals(21, s.getAge().intValue());
		
		comp.removeStudent(id);
		allStudents = comp.getAllStudents();
		Assert.assertEquals(1, allStudents.size());
		
		s = allStudents.get(0);
		Assert.assertEquals(id2, s.getStudentId());
		Assert.assertEquals("someName", s.getStudentName());
		Assert.assertEquals(21, s.getAge().intValue());
		
		deleteSampleStudent(id2);
		
		
	}


	@Test
	public void testUpdateStudent() throws FDTException {
		long id = createSampleStudent();
		StudentDto s = comp.getStudentById(id);
		Assert.assertNotNull(s);
		Assert.assertEquals(id, s.getStudentId());
		Assert.assertEquals("someName", s.getStudentName());
		Assert.assertEquals(21, s.getAge().intValue());
		
		StudentDto update = new StudentDto();
		update.setAge(31);
		update.setStudentName("New Name");
		update.setStudentId(s.getStudentId());
		comp.updateStudent(update);
		
		s = comp.getStudentById(id);
		Assert.assertNotNull(s);
		Assert.assertEquals(id, s.getStudentId());
		Assert.assertEquals("New Name", s.getStudentName());
		Assert.assertEquals(31, s.getAge().intValue());
		
		deleteSampleStudent(id);
	}
	
	@Test(expected=FDTException.class)
	public void testUpdateStudentThrowExceptionWhenStudentNotFound() throws FDTException {
		StudentDto newStudent = new StudentDto();
		newStudent.setAge(31);
		newStudent.setStudentName("New Name");
		newStudent.setStudentId(1000); //this id should not be in db
		comp.updateStudent(newStudent);
		
	}
	
	private void deleteSampleStudent(long id) {
		comp.removeStudent(id);
		
	}

	private long createSampleStudent() {
		StudentDto s = new StudentDto();
		s.setAge(21);
		s.setStudentName("someName");
		return comp.addStudent(s);
	}


}
