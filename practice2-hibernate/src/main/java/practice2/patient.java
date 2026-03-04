package practice2;
import javax.persistence.*;

@Entity
@Table(name="Patient")

public class patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private Integer age;
	
	public  patient() { }
	public patient(String n) {
		this.name=n;
	}
	public patient(String n,Integer a) {
		this.name=n;
		this.age=a;
	}
	public void setAge(Integer i) {
		this.age=i;
	}
}
