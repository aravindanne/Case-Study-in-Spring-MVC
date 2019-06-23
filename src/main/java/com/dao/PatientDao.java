package com.dao;

import java.util.List;

import com.model.Patient;

public interface PatientDao {
	public boolean saveOrUpdate(Patient patient);

	public List<Patient> listAllPatients();

	public Patient getPatientById(String id);
}
