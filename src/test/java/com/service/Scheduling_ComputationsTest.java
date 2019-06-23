package com.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.model.Response;

public class Scheduling_ComputationsTest {

	private Scheduling_Computations scheduling_comp;

	@Before
	public void setUp() throws Exception {
		scheduling_comp = new Scheduling_Computations();

	}

	@Test
	public void process_doctor_information_postive_case() {
		int start = 11;
		int end = 12;
		Response test = scheduling_comp.process_doctor_information(start, end);
		Assert.assertEquals(1, test.getId());
	}

	@Test
	public void process_doctor_information_negative_case() {
		int start = 10;
		int end = 11;
		Response test = scheduling_comp.process_doctor_information(start, end);
		Assert.assertEquals(null, test);
	}

	@Test
	public void process_room_information_positive_case() {
		int room_id = 1;
		int start = 10;
		int end = 11;
		Response res = scheduling_comp.process_room_information(room_id, start, end);
		Assert.assertEquals(1, res.getId());
	}

}
