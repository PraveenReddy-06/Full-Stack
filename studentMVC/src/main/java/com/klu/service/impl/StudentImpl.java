package com.klu.service.impl;
import com.klu.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.klu.model.Student;

@Service
public class StudentImpl implements StudentService{
	
	Scanner sc= new Scanner(System.in);
	private List<Student> studentList = new ArrayList<>();
	
	@Override
	public String getWelcome() {
		return "I'm Hulk";
	}
	
	@Override
	public Student createStudent(Student s) {
		studentList.add(s);
		return s;
	}
	
	@Override
	public Student getStudentById(int id) {
		for(Student s:studentList ) {
			if(s.getId()==id) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public List<Student> getAllStudents(){
		return studentList;
	}

	@Override
	public Student updateStudent(int sid, Student student) {

	    for(Student s: studentList) {
	        if(s.getId() == sid) {

	            s.setName(student.getName());
	            s.setCourse(student.getCourse());

	            return s;
	        }
	    }
	    return null;
	}


	@Override
	public String deleteStudent(int id) {
		for(Student s:studentList) {
			if(s.getId()==id) {
				studentList.remove(s);			
				return "Student Deleted"+s.getName();
			}
		}
		return "No Student Deleted";
	}

	@Override
	public List<Student> searchStudent(String name, String c) {
		List<Student> stud = new ArrayList<>();
		for(Student s :studentList) {
			if(s.getName().equals(name) && s.getCourse().equals(c)) {
				stud.add(s);
			}
		}
		return stud;
	}
	
	
	
	

}
