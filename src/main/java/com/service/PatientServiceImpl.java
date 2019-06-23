package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PatientDao;
import com.model.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	PatientDao patientDao; // = new PatientDaoImpl();

	private static List<Patient> patient = new ArrayList<Patient>(Arrays.asList(
			new Patient("1", "Aravind", "male", "1993-10-08"), new Patient("2", "Viswa", "male", "1993-08-07"),
			new Patient("3", "Saumiya", "female", "1994-02-12")));

	@Autowired
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	public List<Patient> getAllPatients() {
		try {
			return patientDao.listAllPatients();
		} catch (Exception e) {
			// In case if the DAO doesn't work, return the static parameter, so that it
			// makes the application demoable...
			// My system has some problem while connecting to jpa sometimes. so came up with
			// this idea. and you can also run this project in your local system.
			return patient;
		}
	}

	public Patient getPatientById(String id) {

		try {
			return patientDao.getPatientById(id);
		} catch (Exception e) {
			for (Patient p : patient) {
				if (p.getId().equals(id)) {
					return p;
				}
			}
		}
		return null;
	}

	public String addPatient(String name, String sex, String dob) {

		try {
			Patient ls_p = new Patient(name, sex, dob);
			patientDao.saveOrUpdate(ls_p);
			return ls_p.getId();

		} catch (Exception e) {
			String id = String.valueOf(patientid++); // generateId();
			Patient ls_p = new Patient(id, name, sex, dob);
			patient.add(ls_p);
			return id;
		}
	}

	public String generateId() {
		Date date = new Date();
		SimpleDateFormat idformat = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");
		String s = idformat.format(date);
		s = s.replace("+", "");
		return s;
	}

	static int patientid = 4;

}
