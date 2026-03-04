package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class MainApp {
	public static void main(String args[]) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		Student s1 = new Student("Praveen");
		Student s2 = new Student("Asif");
		Student s3 = new Student("Karthik");
		
		s.save(s1);
		s.save(s2);
		s.save(s3);
		tx.commit();
		
		s.close();
		factory.close();
		
		System.out.println("Data have been inserted");
		
	}
	
}
