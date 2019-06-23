package com.dataset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.enums.BookingType;
import com.model.Bookings;
import com.model.Rooms;
import com.model.Timings;

public class RoomData {

	private static List<Rooms> rooms = new LinkedList<Rooms>();
	private static Map<Integer, Rooms> idVsRooms = new HashMap<Integer, Rooms>();

	private static void Get_room_dataset_d1() {
		List<Bookings> booking1 = new ArrayList<Bookings>();
		Bookings book1 = new Bookings(1, BookingType.Doctor, 1, 9, 10);
		booking1.add(book1);
		Timings timing = new Timings(9, 20, booking1);
		Rooms r1 = new Rooms(1, "ECG", timing);
		rooms.add(r1);
	}

	private static void Get_room_dataset_d2() {
		List<Bookings> booking1 = new ArrayList<Bookings>();
		Bookings book1 = new Bookings(2, BookingType.Doctor, 2, 11, 12);
		Bookings book2 = new Bookings(3, BookingType.Doctor, 1, 16, 17);
		booking1.add(book1);
		booking1.add(book2);
		Timings timing = new Timings(9, 20, booking1);
		Rooms r2 = new Rooms(2, "CTSCAN", timing);
		rooms.add(r2);
	}

	public static void load_doctor_data_set() {
		Get_room_dataset_d1();
		Get_room_dataset_d2();
		for (Rooms room : rooms) {
			idVsRooms.put(room.getId(), room);
		}
	}

	public static Map<Integer, Rooms> prepare_rooms_id_vs_rooms() {
		return idVsRooms;
	}

	public static boolean update_room_bookings(int room_id, int timing_index, Bookings booking) {
		Rooms room = idVsRooms.get(room_id);
		room.getTimes().add_bookings(booking);
		return true;
	}
}
