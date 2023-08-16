package com.clinic;

import javax.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    public String doctorId;

    @Column(name = "doctor_name")
    public String doctorName;

    @Column(name = "specialization")
    public String specialization;
    
    @Column(name = "Email")
    public String Email;
    
    @Column(name = "ContactNumber")
    public String ContactNumber;

	public Doctor(String doctorId, String doctorName, String specialization, String Email, String contactNumber2) {
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.Email = Email;
		this.ContactNumber = contactNumber2;
	
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String ContactNumber) {
		this.ContactNumber = ContactNumber;
		// TODO Auto-generated method stub
		
	}

	


	
}



    