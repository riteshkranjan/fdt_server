package com.bt.fdt.server.component;

import java.util.List;

import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.exception.FDTException;

public interface StudentComponent {
	
	StudentDto getStudentById(long id);
	
	List<StudentDto> getAllStudents();
	
	long addStudent(StudentDto d);
	
	void removeStudent(long id);

	void updateStudent(StudentDto d) throws FDTException;

}
