package com.clinic.dao;

import org.hibernate.Session;

import com.clinic.Helper;
import com.clinic.Patient;

import java.util.List;

public class PatientDao implements GenericDao<Patient> {

    @Override
    public void add(Patient patient) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Patient patient) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            session.update(patient);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.delete(patient);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Patient getById(int id) {
        try (Session session = Helper.getSession()) {
            return session.get(Patient.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Patient> getAll() {
        try (Session session = Helper.getSession()) {
            return session.createQuery("FROM Patient", Patient.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	public void createPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}
}


