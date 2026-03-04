package com.klu.main;

import com.klu.model.CourseRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CourseRegistration cr =
                (CourseRegistration) context.getBean("courseReg");

        cr.display();
    }
}
