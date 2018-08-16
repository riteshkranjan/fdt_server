package com.bt.fdt.server.service;

import java.util.List;

import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.exception.FDTException;

public interface StudentService {

	StudentDto getStudentById(long id);

	List<StudentDto> getAllStudents();

	long addStudent(StudentDto d) throws FDTException;

	void removeStudent(long id);

	void updateStudent(StudentDto d) throws FDTException;

}
