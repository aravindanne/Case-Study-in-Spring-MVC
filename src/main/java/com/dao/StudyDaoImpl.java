package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Study;

@Repository
public class StudyDaoImpl implements StudyDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean saveOrUpdate(Study study) {
		try {
			getSession().saveOrUpdate(study);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Study> listAllStudy() {
		Criteria criteria = getSession().createCriteria(Study.class);
		return (List<Study>) criteria.list();
	}

	public Study getStudyById(String id) {
		Study s = (Study) getSession().get(Study.class, id);
		return s;
	}

}
