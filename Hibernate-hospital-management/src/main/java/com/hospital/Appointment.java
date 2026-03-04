package com.hospital;
import javax.persistence.*;

@Entity
@Table(name="appointment")

public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Appointment_id;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient appointment_patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor appointment_doctor;
	
	public void setPatientAppointment(Patient p) {
		this.appointment_patient=p;
	}
	public void setDoctorAppointment(Doctor d) {
		this.appointment_doctor=d;
	}
	
	public Patient getPatient() {
		return this.appointment_patient;
	}
	public Doctor getDoctor() {
		return this.appointment_doctor;
	}
	public int getAppointmentId() {
		return this.Appointment_id;
	}
}
