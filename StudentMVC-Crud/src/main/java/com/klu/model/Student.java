package com.klu.model;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String course;
	
	public Student() {}
	
	public Student(String n,String c) {
		this.name=n;
		this.course=c;
	}
	public void setName(String n) {
		this.name=n;
	}
	public void setCourse(String c) {
		this.course=c;
	}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getCourse() {
		return this.course;
	}
	
	
}
