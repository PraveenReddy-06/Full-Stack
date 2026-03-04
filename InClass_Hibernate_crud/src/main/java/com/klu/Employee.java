package com.klu;
import javax.persistence.*;

@Entity
@Table(name="Emp")


public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int Emp_id;
	private String Emp_name;
	private double Salary;
	@ManyToOne
	@JoinColumn(name="depart_id")
	private Department department;/*---------------------------------------------------------------------------------------------------IMPORTANT*/
	
	public void setEmpId(int id) {
		this.Emp_id=id;
	}
	public int getEmpId() {
		return Emp_id;
	}
	public void setEmpName(String s) {
		this.Emp_name=s;
	}
	public String getEmpName() {
		return Emp_name;
	}
	public void setSalary(double s) {
		this.Salary=s;
	}
	public double getSalary() {
		return Salary;
	}
	
	public void setDepartment(Department d) {
		this.department=d;
	}
	public Department getDepartment() {
		return department;
	}
	
}
