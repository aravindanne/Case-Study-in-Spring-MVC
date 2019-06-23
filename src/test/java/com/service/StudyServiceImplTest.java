package com.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.model.Study;

public class StudyServiceImplTest {

	private StudyService studyService;

	@Before
	public void setUp() throws Exception {
		studyService = new StudyServiceImpl();
	}

	@Test
	public void testGetAllStudy() {
		List<Study> act_study = studyService.getAllStudy();
		Assert.assertEquals("Desc 1", act_study.get(0).getDescription());

	}

	@Test
	public void testAddStudy() {
		String act = studyService.addStudy("1", "Testing", 11, 12, 1);
		Assert.assertEquals("Doctor/Room not found or overlapped", act);
	}

	@Test
	public void testUpdateStatus() {
		boolean act = studyService.updateStatus("1");
		Assert.assertEquals(true, act);

		act = studyService.updateStatus("1");
		Assert.assertEquals(true, act);

		act = studyService.updateStatus("1");
		Assert.assertEquals(false, act);

	}

}
