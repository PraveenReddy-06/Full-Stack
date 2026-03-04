package com.klu.service;

import java.util.List;

import com.klu.model.Student;

public interface ServiceInter {

	String getWelcome();
	Student createStudent(Student s);
	Student getStudentById(int id);
	List<Student> getStudentsList();
	
}
