package com.bt.fdt.server.mapping;

import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.entity.Student;

public class StudnetMapping {
	
	public static Student dtoToEntity(StudentDto d) {
		Student e = new Student();
		e.setAge(d.getAge());
		e.setStudentName(d.getStudentName());
		return e;
		
	}
	
	public static StudentDto entityToDto(Student e) {
		StudentDto d = new StudentDto();
		d.setAge(e.getAge());
		d.setStudentName(e.getStudentName());
		d.setStudentId(e.getStudentId());
		return d;
	}

}
