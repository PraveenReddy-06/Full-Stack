package transport.App;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

import transport.*;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		
		Session s = f.openSession();
		Transaction tr = s.beginTransaction();
		
		Customer c1 = new Customer("a");
		Customer c2= new Customer("b");
		
		Bike b1= new Bike("BMW",2000.0);
		Bike b2= new Bike("Benz",1000);
		Bike b3= new Bike("Audi",3000);
		
		c1.addBike(b1);
		c2.addBike(b2);
		c1.addBike(b3);
		
		s.save(c1);
        s.save(c2);

        tr.commit();
        s.close();
        f.close();
		System.out.println("Created Sucessfullly");
	}
}
