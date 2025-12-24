package com.klu.App;
import javax.persistence.*;
import org.hibernate.*;
import com.klu.*;
import com.klu.util.*;
import java.util.*;

public class MainApp {
	
	static SessionFactory f = Hibernate_Util.getSessionFactory();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("====== STUDENT CRUD MENU ======");
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			
			choice = sc.nextInt();
			sc.nextLine();
				switch (choice) {
					case 1: insertEmp(sc); break;
					case 2: veiwEmployee(sc); break;
					case 3: updateEmployee(sc); break;
					/*case 4: deleteEmployee(sc); break;*/
					default: System.out.println("Invalid Choice");
					}
			}while (choice != 5);
		
		f.close();
		sc.close();
}	
	
private static void insertEmp(Scanner sc) {
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		
		Employee e = new Employee();
		
		System.out.print("Enter Employee Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Salary: ");
		double sal = sc.nextDouble();
		sc.nextLine();
		e.setEmpName(name);
		e.setSalary(sal);

		Department d = new Department();
		System.out.print("Enter Department Name: ");
		String depName = sc.nextLine();
		d.setDepartName(depName);
		
		s.save(d);
		s.save(e);
		
		tx.commit();
		s.close();
	}
private static void veiwEmployee(Scanner sc) {
	Session s = f.openSession();
	Transaction tx= s.beginTransaction();
	
	System.out.println("Enter id to veiw Employee");
	int id= sc.nextInt();
	
	Employee e=s.get(Employee.class, id);
	
	if (e != null) {
        System.out.println("ID      : " + e.getEmpId());
        System.out.println("Name    : " + e.getEmpName());
        System.out.println("Salary  : " + e.getSalary());
    } else {
        System.out.println("Employee not found");
    }

    s.close();
}

private static void updateEmployee(Scanner sc) {
	Session s = f.openSession();
	Transaction tx= s.beginTransaction();
	
	System.out.println("Enter Emp id to Update salary: ");
	int id = sc.nextInt();
	
	Employee e = s.get(Employee.class, id);
	
	if(e!=null) {
	System.out.println("Enter Salary you want to update: ");
	double d = sc.nextDouble();
	e.setSalary(d);
	tx.commit();
	System.out.println("Salary updated successfully");
	}
	else {
		 System.out.println("Employee not found");
	     tx.rollback();
	}
	s.close();
}

}
