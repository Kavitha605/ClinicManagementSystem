package com.clinic;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.clinic.dao.PatientDao;
import com.clinic.dao.DoctorDao;

public class App {

    private PatientDao patientDao;
    private DoctorDao doctorDao;
    private Scanner scanner;

    public App() {
        patientDao = new PatientDao(); // Initialize with appropriate implementation
        doctorDao = new DoctorDao();   // Initialize with appropriate implementation
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Create Patient");
        System.out.println("2. Create Doctor");
        System.out.println("3. Create Appointment");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createPatient();
                    break;
                case "2":
                    createDoctor();
                    break;
                 case "3":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    public void createPatient() {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Medical History: ");
        String medicalHistory = scanner.nextLine();
        
        System.out.print("Contact details: ");
        String contactDetails = scanner.nextLine();

        Patient patient = new Patient(patientId, name, medicalHistory, contactDetails);
        patientDao.createPatient(patient);
        System.out.println("Patient created successfully.");
    }

    public void createDoctor() {
        System.out.print("Enter doctor ID: ");
        String doctorId = scanner.nextLine();
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        Doctor doctor = new Doctor(doctorId, name, specialization, email, contactNumber);
        doctorDao.createDoctor(doctor);
        System.out.println("Doctor created successfully.");
    }

        public static void main(String[] args) {
        	
        	SessionFactory sf = new Configuration().configure().buildSessionFactory();
    		Session session = sf.openSession();
    		Transaction t = session.beginTransaction();
    		
        App mainApp = new App();
        mainApp.run();
    }
}
