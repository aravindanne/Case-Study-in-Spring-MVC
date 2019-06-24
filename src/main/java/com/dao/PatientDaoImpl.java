package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.Patient;

@Service
@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean saveOrUpdate(Patient patient) {
		try {
			getSession().saveOrUpdate(patient);
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return false;
		}
	}

	public List<Patient> listAllPatients() {
		Criteria criteria = getSession().createCriteria(Patient.class);
		return (List<Patient>) criteria.list();
	}

	public Patient getPatientById(String id) {
		Patient p = (Patient) getSession().get(Patient.class, id);
		return p;
	}

}
