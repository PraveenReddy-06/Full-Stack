package com.practice;
import javax.persistence.*;

@Entity
@Table(name="Person")

public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private int age;
	
	public Person(String s,int a) {
		this.name=s;
		this.age=a;
	}
	
}
