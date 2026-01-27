package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Library {

	private int libraryId;
	private String libraryName;
	
	@Autowired
	private Book book;
	
	public Library(@Value("99") int libId,@Value("VD") String ln) {
		this.libraryId=libId;
		this.libraryName=ln;
	}
	public void setBook(Book b) {
		this.book=b;
	}
	
	@Override
	public String toString() {
		return "This is "+libraryName+" Library, of Id " +libraryId + "contains "+book;
	}
}
