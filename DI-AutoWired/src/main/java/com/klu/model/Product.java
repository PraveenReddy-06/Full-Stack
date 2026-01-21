package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {

	private int productId;
	private String ProductName;
	private String category;
	private double price;
	
	public Product(@Value("")int pid, @Value("")String pn, @Value("")String c, @Value("")double p) {
		this.productId=pid;
		this.ProductName=pn;
		this.category=c;
		this.price=p;
	}
	public Product() {
		this.category="ECE";
		this.price=100;
		this.productId=18;
		this.ProductName="Soap";
	}
	public String getProductName() {
		return this.ProductName;
	}
	public String getCategory() {
		return this.category;
	}
	public int getProductId() {
		return this.productId;
	}
	public double getPrice() {
		return this.price;
	}
}
