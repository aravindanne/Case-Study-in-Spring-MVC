package com.model;

import com.enums.BookingType;

public class Bookings {
	BookingType bookingType;
	int start_time;
	int end_time;
	int booking_id;
	int booking_type_id;

	public Bookings(int booking_id, BookingType bookingType, int booking_type_id, int start_time, int end_time) {
		super();
		this.booking_id = booking_id;
		this.bookingType = bookingType;
		this.start_time = start_time;
		this.end_time = end_time;
		this.booking_id = booking_type_id;
	}

	public int getBooking_type_id() {
		return booking_type_id;
	}

	public void setBooking_type_id(int booking_type_id) {
		this.booking_type_id = booking_type_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public BookingType getBookingType() {
		return bookingType;
	}

	public void setBookingType(BookingType bookingType) {
		this.bookingType = bookingType;
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

}
