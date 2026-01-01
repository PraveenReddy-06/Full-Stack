package com.hospital;
import java.util.*;
import javax.persistence.TypedQuery;
import org.hibernate.*;

import org.hibernate.cfg.Configuration;

public class MainApp {

	static SessionFactory f = new Configuration().configure("hospital.cfg.xml").buildSessionFactory();
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("1.Add Patient");
			System.out.println("2.Add Doctor");
			System.out.println("3.Book Appointment");
			System.out.println("4.Veiw Appointments of Doctors And Patients");
			System.out.println("5.Update Appointmnets(doctor unavailable)");
			System.out.println("6.Cancel Appointmnet");
			System.out.println("7 to Exit");

			System.out.println("Enter A Choice: ");
			choice=sc.nextInt();
			switch(choice) {
				case 1:	addPatient(sc);break;
				case 2: addDoctor(sc); break;
			    case 3: bookAppointment(sc); break;
			    case 4: veiwAppointments(sc); break;
			    case 5: updateAppointment(sc); break;
			    case 6: cancelAppointment(sc); break;
			    
			    default: System.out.println("Invalid Choice");
			}
		}while(choice!=7);
	
		sc.close();
	}
	
	public static void addPatient(Scanner sc) {
		
		Session s = f.openSession();
		Transaction tx= s.beginTransaction();
		
		System.out.println("Enter Patient Name: ");
		String n=sc.next();
		Patient p = new Patient();
		
		p.setPatientName(n);
		
		s.save(p);
		tx.commit();
	}
	public static void addDoctor(Scanner sc) {
		Session s = f.openSession();
		Transaction tx= s.beginTransaction();
		
		System.out.println("Enter Doctor Name: ");
		String n=sc.next();
		Doctor d = new Doctor();
		
		d.setDoctorName(n);
		s.save(d);
		tx.commit();
	}
	public static void bookAppointment(Scanner sc) {
		
		Session s = f.openSession();
		Transaction tx= s.beginTransaction();
		
		System.out.println("Enter Patient id: ");
		int pid=sc.nextInt();
		System.out.println("Enter Doctor id: ");
		int did=sc.nextInt();
		
		Appointment a= new Appointment();
		
		Patient p = s.get(Patient.class,pid);
		p.addPatientAppointment(a);
		
		Doctor d=s.get(Doctor.class, did);
		d.setDoctorAppointment(a);
		
		s.save(a);
		tx.commit();
	}
	public static void veiwAppointments(Scanner sc) {
		Session s = f.openSession();
		
		TypedQuery<Appointment> query = s.createQuery("from Appointment ",Appointment.class);
		
		List<Appointment> list = query.getResultList();
		
		for(Appointment a :list) {
			 System.out.println(" Patient: " + a.getPatient().getPatientName() +"		 | Doctor: " + a.getDoctor().getDoctorName());
		}
		s.close();	
		
	}
	public static void updateAppointment(Scanner sc) {

	    Session s = f.openSession();
	    Transaction tx = s.beginTransaction();

	    System.out.println("Enter Appointment Id:");
	    int aid = sc.nextInt();

	    Appointment a = s.get(Appointment.class, aid);
	    if (a == null) {
	        System.out.println("Appointment not found");
	        s.close();
	        return;
	    }

	    Doctor oldDoctor = a.getDoctor();

	    System.out.println("Enter New Doctor Id:");
	    int did = sc.nextInt();

	    Doctor newDoctor = s.get(Doctor.class, did);
	    if (newDoctor == null) {
	        System.out.println("Doctor not found");
	        s.close();
	        return;
	    }

	    if (oldDoctor != null) {
	        oldDoctor.removeAppointment(a);
	    }

	    newDoctor.setDoctorAppointment(a); 

	    tx.commit();
	    s.close();
	}

	public static void cancelAppointment(Scanner sc) {
		Session s=f.openSession();
		Transaction tx= s.beginTransaction();
		
		System.out.println("Enter Appointment Id to cancel :");
		int aid=sc.nextInt();
		Appointment a =s.get(Appointment.class, aid);
		
		Doctor d = a.getDoctor();
	    if (d != null) {
	        d.removeAppointment(a);
	    }

	    Patient p = a.getPatient();
	    if (p != null) {
	        p.removeAppointment(a);
	    }

	    s.delete(a);
	    tx.commit();
	    s.close();
	}
	
}
