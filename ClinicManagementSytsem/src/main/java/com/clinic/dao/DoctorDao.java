package com.clinic.dao;

import java.util.List;

import org.hibernate.Session;

import com.clinic.Doctor;

import com.clinic.Helper;

public class DoctorDao implements GenericDao<Doctor> {

    @Override
    public void add(Doctor doctor) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Doctor doctor) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            session.update(doctor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                session.delete(doctor);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor getById(int id) {
        try (Session session = Helper.getSession()) {
            return session.get(Doctor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> getAll() {
        try (Session session = Helper.getSession()) {
            return session.createQuery("FROM Doctor", Doctor.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	public void createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}
}
