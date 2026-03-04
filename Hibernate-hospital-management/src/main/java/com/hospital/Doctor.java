package com.hospital;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="doctor")

public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctor_id;
	
	private String doctor_name;
	
	@OneToMany(mappedBy="appointment_doctor")
	List<Appointment> doctor_appointments = new ArrayList<>();
	
	public void setDoctorName(String n) {
		this.doctor_name=n;
	}
	public String getDoctorName() {
		return this.doctor_name;
	}
	
	public void setDoctorAppointment(Appointment a) {
		doctor_appointments.add(a);
		a.setDoctorAppointment(this);
	}
	public List<Appointment> getdoctor_appointments() {
		return this.doctor_appointments;
	}
	public void removeAppointment(Appointment a) {
		doctor_appointments.remove(a);
	}
}
