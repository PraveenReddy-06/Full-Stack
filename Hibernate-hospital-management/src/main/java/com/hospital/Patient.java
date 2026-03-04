package com.hospital;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="patient")

public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patient_id;
	
	private String patient_name;
	
	@OneToMany(mappedBy="appointment_patient",cascade=CascadeType.ALL)
	List<Appointment> patient_appointments= new ArrayList<>();
	
	public void setPatientName(String n) {
		this.patient_name=n;
	}
	public String getPatientName() {
		return this.patient_name;
	}
	
	public void addPatientAppointment(Appointment a) {
		patient_appointments.add(a);
		a.setPatientAppointment(this);
	}
	public List<Appointment> getPatientAppointmnets(){
		return this.patient_appointments;
	}
	public void removeAppointment(Appointment a) {
	    patient_appointments.remove(a);
	}

}
