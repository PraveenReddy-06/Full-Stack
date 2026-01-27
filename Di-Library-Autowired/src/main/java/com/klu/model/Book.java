package com.klu.model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
	
	private int bookId;
	private String bookName;
	private double price;
	
	public Book(@Value("7") int bI,@Value("HarryPorter")String bn) {
		this.bookId=bI;
		this.bookName=bn;
	}
	
	@Value("1000")
	public void setBookPrice(double p) {
		this.price=p;
	}
	
	@Override
	public String  toString() {
		return "THis is "+ this.bookName + " book id "+ this.bookId+"costs : "+this.price;
	}
}
