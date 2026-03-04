package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.ServiceInter;

@RestController
@RequestMapping("/api") 
public class StudentController {
	
	@Autowired
	private ServiceInter service;
	
	@GetMapping("/student/greet")
	public String getWelcome() {
		return service.getWelcome();
	}
	
	@PostMapping("/student/add")
	public Student createStudent(@RequestBody Student s) {
		return service.createStudent(s);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentByid(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	@GetMapping("/student/getStudents")
	public List<Student> getStudentList(){
		return service.getStudentsList();
	}

}
