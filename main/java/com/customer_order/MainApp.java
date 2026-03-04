package com.customer_order;
import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class MainApp {

	static SessionFactory f = new Configuration().configure("orders.cfg.xml").buildSessionFactory();
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------CUSTOMER ORDER MENU-------");
            System.out.println("1. Add Customer with Orders");
            System.out.println("2. Add a new Product ");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Total Number of Customers (COUNT)");
            System.out.println("6. Total Orders Count (COUNT)");
            System.out.println("7. Total Revenue (SUM of Order Price)");
            System.out.println("8. Average Order Price (AVG)");
            System.out.println("9. Highest Order Price (MAX)");
            System.out.println("10. Lowest Order Price (MIN)");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
            case 1: insertCustomer(sc); break;
            case 2: addOrder(sc); break;
        
            case 11: System.out.println("Exiting application..."); break;
            default: System.out.println("Invalid Choice! Try again.");
            }

        } while (choice != 11);

    }
	
	public static void insertCustomer(Scanner sc) {
		
		Session s = f.openSession();
		Transaction tx= s.beginTransaction();
		
	    System.out.print("Enter Customer Name: ");
	    String name = sc.nextLine();

	    System.out.print("Enter Age: ");
	    int age = sc.nextInt();
		
		Customer c= new Customer(name,age);
		
		System.out.println("Enter Order id :");
		int id=sc.nextInt();
		Order o = s.get(Order.class, id);
		
		c.AddOrder(o);
		
		s.save(c);
		tx.commit();
	}
	
	public static void addOrder(Scanner sc) {
		Session s = f.openSession();
		Transaction tx =  s.beginTransaction();
		
		  System.out.print("Enter Product name: ");
		  String name = sc.nextLine();

		  System.out.print("Enter Price: ");
		  double price = sc.nextDouble();
		
		Order o = new Order(name,price);

		s.save(o);
		tx.commit();		
	}
}


