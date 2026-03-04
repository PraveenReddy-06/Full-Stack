package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {

	private int orderId;
	private String customerName;
	private int quantity;
	
	@Autowired
	private Product product; // look here
	
	public Order() {
		this.customerName="Praveen";
		this.orderId=1;
		this.quantity=100;
	}
	
	public void display() {
		System.out.println("Order Details:");
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Product Details:");
        System.out.println("Product ID   : " + product.getProductId());
        System.out.println("Product Name : " + product.getProductName());
        System.out.println("Price        : " + product.getPrice());
        
    }
}
