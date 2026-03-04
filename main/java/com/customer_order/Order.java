package com.customer_order;
import javax.persistence.*;

@Entity
@Table(name="orderTable")

public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_id;
	
	private String product_name;
	private double price;
												/*----------------------------------create a foreign key column --------------------------------------------*/
	@ManyToOne
	@JoinColumn(name="ordered_customer_id")
	private Customer ordered_customer;
												/**************** constructor******************/
	public Order() {}
	public Order(String n,double p) {
		this.product_name=n;
		this.price=p;
	}
												/************* add customer to foreign key column i.e ordered customer;**************/
	public void setCustomer(Customer c) {
		this.ordered_customer=c;
	}
												/********************     Getters********************/
	public String getProductName() {
		return this.product_name;
	}
	public double getProductPrice() {
		return this.price;
	}
	public int getOrderId() {
		return this.order_id;
	}
	
}
