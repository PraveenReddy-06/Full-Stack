package com.klu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repo.StudentRepository;
import com.klu.service.ServiceInter;

@Service
public class StudentImpl implements ServiceInter{

	@Autowired
	private StudentRepository repo;
	
	@Override 
	public String getWelcome() {
		return "I'm Hulk";
	}
	
	@Override
	public Student createStudent(Student s) {
		return repo.save(s);
	}
	
	@Override
	public Student getStudentById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	@Override
	public List<Student> getStudentsList(){
		return repo.findAll();
	}
}
