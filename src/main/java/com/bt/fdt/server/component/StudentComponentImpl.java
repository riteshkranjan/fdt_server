package com.bt.fdt.server.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.fdt.server.dao.StudentRepository;
import com.bt.fdt.server.dto.StudentDto;
import com.bt.fdt.server.entity.Student;
import com.bt.fdt.server.exception.FDTException;
import com.bt.fdt.server.mapping.StudentMapping;

@Component
@Transactional
public class StudentComponentImpl implements StudentComponent {
	private static final Logger logger = LoggerFactory.getLogger(StudentComponentImpl.class);

	@Autowired
	StudentRepository repo;

	@Override
	public StudentDto getStudentById(long id) {
		Optional<Student> findById = repo.findById(id);
		if (findById.isPresent())
			return StudentMapping.entityToDto(findById.get());
		logger.error("Student not found with id = " + id);
		return null;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		Iterable<Student> students = repo.findAll();
		List<StudentDto> response = new ArrayList<>();
		for (Student s : students) {
			response.add(StudentMapping.entityToDto(s));
		}
		logger.debug("total student found in db = " + response.size());
		return response;
	}

	@Override
	public long addStudent(StudentDto d) {
		Student entity = StudentMapping.dtoToEntity(d);
		entity.setDateInserted(new Date());
		Student s = repo.save(entity);
		return s.getStudentId();
	}

	@Override
	public void removeStudent(long id) {
		repo.deleteById(id);
	}

	@Override
	public void updateStudent(StudentDto d) throws FDTException {
		Student e = repo.findByStudentId(d.getStudentId());
		if (e == null) {
			logger.error("Student not found in db with id = " + d.getStudentId());
			throw new FDTException("Student not found in db with id = " + d.getStudentId());
		}
		e.setAge(d.getAge());
		e.setStudentName(d.getStudentName());
		repo.save(e);
	}
}
