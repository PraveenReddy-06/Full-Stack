package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory f= new Configuration().configure().buildSessionFactory();
		
		Session s = f.openSession();
		Transaction t = s.beginTransaction();
		
		Person p1= new Person("Praveen",19);
		Person p2 = new Person("Jasmine",20);
		
		s.save(p1);
		s.save(p2);
		t.commit();
		
		s.close();
		f.close();
		System.out.println("Inserted p1 and p2");

	}

}
