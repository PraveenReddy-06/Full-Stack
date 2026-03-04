package com.klu.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.Config;
import com.klu.model.ProductOrders;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProductOrders p1 = (ProductOrders)context.getBean("ord");
		
		p1.display();
		
		ApplicationContext c2 = new AnnotationConfigApplicationContext(Config.class);
		ProductOrders p2 = c2.getBean(ProductOrders.class);
		p2.display();
	}

}
