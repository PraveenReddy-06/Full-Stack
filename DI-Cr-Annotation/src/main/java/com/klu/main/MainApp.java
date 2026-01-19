package com.klu.main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.klu.config.AppConfig;
import com.klu.model.Cr;
import org.springframework.context.ApplicationContext;


public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		
		Cr cr = context.getBean(Cr.class);                  
		System.out.println(cr);
	}

}
