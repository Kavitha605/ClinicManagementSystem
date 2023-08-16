package com.clinic;

import javax.persistence.*;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "medical_history")
    private String medicalHistory;

    // Constructors, getters, and setters

    public Patient(String patientId2, String name, String medicalHistory2, String contactDetails) {
    }

    public Patient(Long patientId,String patientName,String medicalHistory) {
        this.patientName = patientName;
        this.medicalHistory = medicalHistory;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
