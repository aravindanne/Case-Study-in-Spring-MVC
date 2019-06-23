package com.service;

import java.util.List;
import java.util.Map;

import com.dataset.DoctorData;
import com.dataset.RoomData;
import com.model.Bookings;
import com.model.Doctor;
import com.model.Response;
import com.model.Rooms;
import com.model.Timings;

public class Scheduling_Computations {
	static int doctor_booking_id = 5;
	static int room_booking_id = 5;

	public Scheduling_Computations() {
		DoctorData.load_doctor_data_set();
		RoomData.load_doctor_data_set();
	}
//	public static void main(String[] args) {
//		DocterData.load_doctor_data_set();
//		RoomData.load_doctor_data_set();
//		Scanner scan = new Scanner(System.in);
//		while (true) {
//			System.out.println("Enter start");
//			int to_start = scan.nextInt();
//			System.out.println("Enter end");
//			int to_end = scan.nextInt();
//			System.out.println("Enter room");
//			int room_id = scan.nextInt();
//			Response response_doctor = process_doctor_information(to_start, to_end);
//			if (response_doctor == null) {
//				System.out.println("Doctor not found");
//				continue;
//			}
//			Response response_room = process_room_information(room_id, to_start, to_end);
//			if (response_room == null) {
//				System.out.println("Room not found");
//				continue;
//			}
//			if (response_doctor != null && response_room != null) {
//				System.out.println("DoctorId=" + response_doctor.getId() + " & Room_id=" + response_room.getId()
//						+ " available for the given date");
//				Bookings booking = new Bookings(doctor_booking_id++, BookingType.Room, response_room.getId(), to_start,
//						to_end);
//				response_doctor.getTiming().add_bookings(booking);
//
//				Bookings booking1 = new Bookings(room_booking_id++, BookingType.Doctor, response_doctor.getId(),
//						to_start, to_end);
//				response_room.getTiming().add_bookings(booking1);
//				System.out.println("booked");
//			}
//		}
//	}

	public Response process_doctor_information(int to_start, int to_end) {
		Map<Integer, Doctor> maps = DoctorData.get_doctorIdVsDoctor();
		for (Integer key : maps.keySet()) {
			Doctor doctor = maps.get(key);
			Timings time = doctor.getTimes();
			if ((time.getStart_time() <= to_start && to_end <= time.getEnd_time())) {
				if (process_booking_information(time.getBooking(), to_start, to_end)) {
					return new Response(key, time);
				}
			}
		}
		return null;
	}

	public Response process_room_information(int room_id, int to_start, int to_end) {
		Map<Integer, Rooms> maps = RoomData.prepare_rooms_id_vs_rooms();
		Rooms room = maps.get(room_id);
		Timings time = room.getTimes();
		if ((time.getStart_time() <= to_start && to_end <= time.getEnd_time())) {
			if (process_booking_information(time.getBooking(), to_start, to_end)) {
				return new Response(room_id, time);
			}
		}
		return null;
	}

	private boolean process_booking_information(List<Bookings> bookings, int to_start, int to_end) {
		for (Bookings booking : bookings) {
			if (to_start < booking.getEnd_time() && booking.getStart_time() < to_end)
				return false;
		}
		return true;
	}
}
