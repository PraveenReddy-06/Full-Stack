package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.Order;

public class MainApp {

	public static void main(String[] args) {
		
		/*ApplicationContext c1 = new ClassPathXmlApplicationContext("applicationContext.xml");*/
		
		ApplicationContext c2 = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Order o1 = c2.getBean(Order.class);
		o1.display();
		
	}
}
