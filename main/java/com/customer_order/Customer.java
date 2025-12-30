package com.customer_order;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="customerTable")

public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customer_id;
	
	private String customer_name;
	private int age;
	
	@OneToMany(mappedBy="ordered_customer",cascade=CascadeType.ALL)
	private List<Order> Customer_orders = new ArrayList<>();
	
	public Customer() {}
	public Customer(String n,int a) {
		this.customer_name=n;
		this.age=a;
	}
	
	public void setOrders(Order o) {
		Customer_orders.add(o);
	}
	
	public String getCustomerName() {
		return this.customer_name;
	}
	public int getAge() {
		return this.age;
	}
	
	public void AddOrder(Order o) {
		this.Customer_orders.add(o);
		o.setCustomer(this);
	}
}
