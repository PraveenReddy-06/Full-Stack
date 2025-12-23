package transport;
import javax.persistence.*;

@Entity
@Table(name="bike")


public class Bike {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bike_no;
	
	@ManyToOne
	@JoinColumn(name="cus_id")
	private Customer owns;
	
	
	private String bike_name;
	private double price;
	
	public Bike() {}
	public Bike(String n,double p) {
		this.setBike_name(n);
		this.setPrice(p);
	}
	
	public Customer getOwns() {
	    return owns;
	}
	public void setOwns(Customer owns) {
	    this.owns = owns;
	}
	
	public int getBike_no() {
	    return bike_no;
	}
	public void setBike_no(int bike_no) {
	    this.bike_no = bike_no;
	}
	
	public String getBike_name() {
	    return bike_name;
	}
	public void setBike_name(String bike_name) {
	    this.bike_name = bike_name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double p) {
		this.price=p;
	}
	
	
}
