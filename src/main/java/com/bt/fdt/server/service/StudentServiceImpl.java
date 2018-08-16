package com.bt.fdt.server.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.fdt.server.component.StudentComponent;
import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.exception.FDTException;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	StudentComponent component;

	@Override
	public StudentDto getStudentById(long id) {
		return component.getStudentById(id);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		return component.getAllStudents();
	}

	@Override
	public long addStudent(StudentDto d) throws FDTException {
		if (isEmpty(d.getStudentName())) {
			logger.error("Input incorrect name is mandatory");
			throw new FDTException("Input incorrect name is mandatory");
		}
		return component.addStudent(d);
	}

	private boolean isEmpty(String s) {

		return s == null || s.equals("");
	}

	@Override
	public void removeStudent(long id) {
		component.removeStudent(id);
	}

	@Override
	public void updateStudent(StudentDto d) throws FDTException {
		if (d == null || d.getStudentId() <= 0) {
			logger.error(String.format("incorrect input received - student json is null or id is null"));
			throw new FDTException("Input not correct");
		}
		component.updateStudent(d);

	}

}
