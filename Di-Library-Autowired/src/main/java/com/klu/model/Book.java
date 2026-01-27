package com.klu.model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Book {
	
	private int bookId;
	private String bookName;
	private double price;
	
	public Book( int bI,String bn) {
		this.bookId=bI;
		this.bookName=bn;
	}
	
	public void setBookPrice(double p) {
		this.price=p;
	}
	
	@Override
	public String  toString() {
		return "THis is "+ this.bookName + " book id "+ this.bookId+"costs : "+this.price;
	}
}
