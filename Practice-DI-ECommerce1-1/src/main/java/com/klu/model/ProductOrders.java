package com.klu.model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductOrders {

	private int orderId;
	private String customerName;
	private String ppproductName;
	private int qquantity;
	
	public ProductOrders(@Value("69")int oi,@Value("Bhai")String cn) {
		this.orderId=oi;
		this.customerName=cn;
	}
	
	@Value("odiyamma")
	public void setProductName(String p) {
		this.ppproductName=p;
	}
	@Value("99")
	public void setQuantity(int q) {
		this.qquantity=q;
	}
	
	public void display() {
		System.out.println("Ordered Details :");
		System.out.println("Order ID       : " + orderId);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Product Name   : " + ppproductName);
        System.out.println("Quantity       : " + qquantity);
	}
}
