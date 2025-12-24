package com.klu;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="dept")

public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depart_id;
	
	@Column(unique=true)
	private String depart_name;
	
	
	@OneToMany(mappedBy ="department",cascade=CascadeType.ALL)
	private List<Employee> employees;
	
	public void setDeptId(int id) {
		this.depart_id=id;
	}
	public int getDepartId() {
		return depart_id;
	}
	public void setDepartName(String s) {
		this.depart_name=s;
	}
	public String getDepartName() {
		return depart_name;
	}
	

}
