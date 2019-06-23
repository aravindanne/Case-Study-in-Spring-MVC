package com.service;

import java.util.List;

import com.model.Patient;

public interface PatientService {
	public List<Patient> getAllPatients();

	public Patient getPatientById(String id);

	public String addPatient(String name, String sex, String dob);

}
