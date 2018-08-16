package com.bt.fdt.server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bt.fdt.server.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	Student findByStudentId(long studentId);

}
