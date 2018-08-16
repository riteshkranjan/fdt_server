package com.bt.fdt.server.mapping;

import org.junit.Assert;
import org.junit.Test;

import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.entity.Student;

public class StudentMappingTest {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		StudentMapping m = new StudentMapping();
		StudentDto d = new StudentDto();
		d.setAge(21);
		d.setStudentName("someName");
		Student e = m.dtoToEntity(d);
		Assert.assertEquals("someName", e.getStudentName());
		Assert.assertEquals(21, e.getAge().intValue());
	}

}
