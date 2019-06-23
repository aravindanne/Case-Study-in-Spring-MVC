package com.model;

import java.util.List;

public class Timings {
	int start_time, end_time;
	List<Bookings> booking;

	public Timings(int start_time, int end_time, List<Bookings> booking) {
		super();
		this.start_time = start_time;
		this.end_time = end_time;
		this.booking = booking;
	}

	public int getStart_time() {
		return start_time;
	}

	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	public int getEnd_time() {
		return end_time;
	}

	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}

	public List<Bookings> getBooking() {
		return booking;
	}

	public void setBooking(List<Bookings> booking) {
		this.booking = booking;
	}

	public void add_bookings(Bookings new_booking) {
		booking.add(new_booking);
	}

}
