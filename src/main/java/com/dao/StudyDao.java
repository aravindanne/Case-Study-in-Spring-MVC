package com.dao;

import java.util.List;

import com.model.Study;

public interface StudyDao {

	public boolean saveOrUpdate(Study study);

	public List<Study> listAllStudy();

	public Study getStudyById(String id);

}
