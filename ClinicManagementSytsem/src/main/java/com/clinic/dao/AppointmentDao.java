package com.clinic.dao;

import org.hibernate.Session;

import com.clinic.Helper;
import com.clinic.Appointment;

import java.util.List;

public class AppointmentDao implements GenericDao<Appointment> {

    @Override
    public void add(Appointment appointment) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            session.save(appointment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Appointment appointment) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            session.update(appointment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = Helper.getSession()) {
            session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, id);
            if (appointment != null) {
                session.delete(appointment);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Appointment getById(int id) {
        try (Session session = Helper.getSession()) {
            return session.get(Appointment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Appointment> getAll() {
        try (Session session = Helper.getSession()) {
            return session.createQuery("FROM Appointment", Appointment.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	public void createAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	
}


