package com.klu.MainApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import com.klu.config.AppConfig;
import com.klu.model.Library;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext c1 = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Library lib = c1.getBean(Library.class);
		System.out.println(lib);
	}
}
