package com.service;

import java.util.List;

import com.model.Study;

public interface StudyService {

	public List<Study> getAllStudy();

//	public Study getPatientById(String id);

	public String addStudy(String patient_id, String description, int ptime, int etime, int room_id);

	public boolean updateStatus(String studyid);
}
