package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudyDao;
import com.enums.BookingType;
import com.model.Bookings;
import com.model.Response;
import com.model.Study;

@Service
@Transactional
public class StudyServiceImpl implements StudyService {

	StudyDao studyDao;

	public static Scheduling_Computations sc = new Scheduling_Computations();
	private static List<Study> study = new ArrayList<Study>(
			Arrays.asList(new Study("1", "123", "Desc 1", "PLANNED", 2, 3, 1, 2),
					new Study("2", "123", "Desc 2", "PLANNED", 3, 4, 2, 2),
					new Study("3", "123", "Desc 1", "PLANNED", 13, 14, 1, 1)));

	@Autowired
	public void setPatientDao(StudyDao studyDao) {
		this.studyDao = studyDao;
	}

	public List<Study> getAllStudy() {
		try {
			return studyDao.listAllStudy();
		} catch (Exception e) {
			return study;
		}
	}

	public String addStudy(String patient_id, String description, int ptime, int etime, int room_id) {

		int doctor_id = getAvailability(room_id, ptime, etime);
		if (doctor_id == -1)
			return "Doctor/Room not found or overlapped";

		String id = String.valueOf(++studyid);// generateId();
		String study_status = "PLANNED";

		try {
			Study s = new Study(patient_id, description, study_status, ptime, etime, room_id, doctor_id);
			studyDao.saveOrUpdate(s);
			return s.getId();

		} catch (Exception e) {
			Study ls = new Study(id, patient_id, description, study_status, ptime, etime, room_id, doctor_id);
			study.add(ls);
			return id;
		}

	}

	public boolean updateStatus(String studyid) {

		Study ls_s;
		try {
			ls_s = studyDao.getStudyById(studyid);
			boolean t = changeStatus(ls_s);
			if (t == true) {
				studyDao.saveOrUpdate(ls_s);
				return true;
			}
			return false;
		} catch (Exception e) {
			for (Study s : study) {
				if (s.getId().equals(studyid)) {
					return changeStatus(s);
				}
			}

		}
		return false;
	}

//	public String generateId() {
//		Date date = new Date();
//		SimpleDateFormat idformat = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");
//		String s = idformat.format(date);
//		s = s.replace("+", "");
//		return s;
//	}

	private int getAvailability(int room_id, int start_time, int end_time) {

		Response response_room = sc.process_room_information(room_id, start_time, end_time);
		if (response_room == null)
			// return "No Free Rooms";
			return -1;

		Response response_doctor = sc.process_doctor_information(start_time, end_time);
		if (response_doctor == null)
			return -1;
		// return "No Doctors Available";

		Bookings booking = new Bookings(doctor_booking_id++, BookingType.Room, response_room.getId(), start_time,
				end_time);
		response_doctor.getTiming().add_bookings(booking);

		Bookings booking1 = new Bookings(room_booking_id++, BookingType.Doctor, response_doctor.getId(), start_time,
				end_time);
		response_room.getTiming().add_bookings(booking1);

		return response_doctor.getId();
		// return "Booked successfully";
	}

	private boolean changeStatus(Study ls_s) {
		String str = ls_s.getStudy_status();
		if (str.equals("PLANNED")) {
			ls_s.setStudy_status("In Process");
			return true;
		} else if (str.equals("In Process")) {
			ls_s.setStudy_status("Finished");
			return true;
		}
		return false;
	}

	static int doctor_booking_id = 5;
	static int room_booking_id = 5;
	static int studyid = 3;

}
