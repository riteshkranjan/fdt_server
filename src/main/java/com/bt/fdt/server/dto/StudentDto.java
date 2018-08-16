package com.bt.fdt.server.dto;

import java.io.Serializable;

public class StudentDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2819024595939517183L;
	private long studentId;
	private Integer age;
	private String studentName;
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
