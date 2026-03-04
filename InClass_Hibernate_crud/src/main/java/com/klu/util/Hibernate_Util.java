package com.klu.util;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Hibernate_Util {
	private static SessionFactory f;
	
	static {  f = new Configuration().configure("InClass_hibernate_crud.cfg.xml").buildSessionFactory(); }
	
	public static SessionFactory getSessionFactory() {
		return f;
	}
	
}
