package practice2;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainApp {
	
	public static void main(String args[]) {
		
		SessionFactory f= new Configuration().configure().buildSessionFactory();
		
		Session s = f.openSession();
		Transaction tr = s.beginTransaction();
		
		patient p1 = new patient("Praveen");
		patient p2 = new patient("Venkey");
		s.save(p1);
		s.save(p2);
		
		String[] names= {
				 "Praveen","Venkey","Ramesh","Suresh","Mahesh",
				    "Naresh","Kiran","Arjun","Rahul","Vikram",
				    "Sanjay","Amit","Anil","Rohit","Manoj",
				    "Deepak","Naveen","Harish","Sathish","Gopal"
				};
		for(String name: names) {
			s.save(new patient(name));
		}
		patient temp = s.get(patient.class, 1);
		temp.setAge(19);
		
		Integer[] ages= { 19,19,20,15,32,22,45,23,14,65,34,23,67,23,32,34,23,12,1,7,3,23,45,46,22,1,19,20,21,18,19,19,20,15,32,22,45,23,14,65,34,23,67,23,45};
		int a=0;
		for(Integer i:ages) {
			s.createQuery("update patient set age=? where id=? ").setParameter(1,i).setParameter(2, a++).executeUpdate();
		}
		/*s.createQuery("update patient set age=20 where age=null ");*/
		
		
		tr.commit();
		
		s.close();
		f.close();
		
		System.out.println("Inserted");
	}

}
