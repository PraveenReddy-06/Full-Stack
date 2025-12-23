package transport;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="client")

public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cus_id;
	
	@Column(unique=true)
	private String cus_name;
	
	@OneToMany(mappedBy="owns", cascade = CascadeType.ALL)
	private List<Bike> bike = new ArrayList<>();

	public Customer() {}
	public Customer(String n) {
		this.setCus_name(n);
	}
	
	public void setCus_id(int ci) {
	    this.cus_id = ci;
	}
	public int getCus_id() {
	    return cus_id;
	}
	public void setCus_name(String cn) {
	    this.cus_name = cn;
	}
	public String getCus_name() {
	    return cus_name;
	}
	
	public void addBike(Bike b) {
		bike.add(b);
		b.setOwns(this);
	}
	
}
