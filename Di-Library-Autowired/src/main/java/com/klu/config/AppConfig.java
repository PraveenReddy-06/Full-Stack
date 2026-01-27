package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.klu.model.Book;
import com.klu.model.Library;

@Configuration
public class AppConfig {
	
	@Bean
	public Book DbmsBook() {
		Book b= new  Book(8,"PiratesOfCb");
		b.setBookPrice(1500);
		return b;
	}
	
	@Bean
	public Book JavaBook() {
		Book b = new Book(9,"Java");
		b.setBookPrice(50);
		return b;
	}
	
	@Bean
	public Library lib1() {
		Library l= new Library(100,"Central");
		l.setBook(JavaBook());
		return l;
	}
	
	@Bean
	public Library lib2() {
		Library l= new Library(200,"online");
		l.setBook(DbmsBook());
		return l;
	}
	
}
