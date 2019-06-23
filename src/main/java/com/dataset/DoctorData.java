package com.dataset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.enums.BookingType;
import com.model.Bookings;
import com.model.Doctor;
import com.model.Timings;

public class DoctorData {

	private static List<Doctor> doctors = new LinkedList<Doctor>();
	private static Map<Integer, Doctor> idVsDoctor = new HashMap<Integer, Doctor>();

	private static void Get_Doctor_dataset_d1() {
		List<Bookings> booking1 = new ArrayList<Bookings>();
		Bookings book1 = new Bookings(1, BookingType.Room, 1, 9, 10); // booked time
		Bookings book2 = new Bookings(2, BookingType.Room, 2, 16, 17);
		// Bookings book3 = new Bookings(3, BookingType.Room, 1, 19, 20);
		booking1.add(book1);
		booking1.add(book2);
		// booking1.add(book3);
		Timings timing = new Timings(9, 17, booking1); // available timing
		Doctor d1 = new Doctor(1, "shan", timing);
		doctors.add(d1);
	}

	private static void Get_Doctor_dataset_d2() {
		List<Bookings> booking1 = new ArrayList<Bookings>();
		Bookings book1 = new Bookings(4, BookingType.Room, 2, 11, 12);
		booking1.add(book1);
		Timings timing = new Timings(11, 20, booking1);
		Doctor d2 = new Doctor(2, "Michael", timing);
		doctors.add(d2);
	}

	private static void prepare_dataset() {
		Get_Doctor_dataset_d1();
		Get_Doctor_dataset_d2();
		for (Doctor doctor : doctors) {
			idVsDoctor.put(doctor.getId(), doctor);
		}
	}

	public static void load_doctor_data_set() {
		prepare_dataset();
	}

	public static Map<Integer, Doctor> get_doctorIdVsDoctor() {
		return idVsDoctor;
	}

	public static boolean update_doctor_bookings(int doctor_id, int timing_index, Bookings booking) {
		Doctor doctor = idVsDoctor.get(doctor_id);
		doctor.getTimes().add_bookings(booking);
		return true;
	}

}
