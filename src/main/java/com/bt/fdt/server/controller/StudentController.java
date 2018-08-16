package com.bt.fdt.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.exception.FDTException;
import com.bt.fdt.server.service.StudentService;

@RestController
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService service;

	@GetMapping("/student/{id}")
	public StudentDto getStudent(@PathVariable final long id) {
		logger.debug("find request received for id "+ id);
		return service.getStudentById(id);
	}

	@GetMapping("/student")
	public List<StudentDto> getAllStudents() {
		logger.debug("find all request received");
		return service.getAllStudents();
	}

	@PostMapping("/student")
	public void updateStudent(@RequestBody final StudentDto d) throws FDTException {
		logger.debug("updating student with id "+ d.getStudentId());
		service.updateStudent(d);
	}

	@PutMapping("/student")
	public long addStudent(@RequestBody final StudentDto d) throws FDTException {
		logger.debug("Adding student with name = "+ d.getStudentName());
		return service.addStudent(d);
	}

	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable final long id) {
		logger.debug("removing student with id = "+ id);
		service.removeStudent(id);
	}
}
