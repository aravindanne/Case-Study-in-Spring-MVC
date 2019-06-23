package com.model;

public class Rooms {
	int id;
	String name;
	Timings times;

	public Rooms(int id, String name, Timings times) {
		super();
		this.id = id;
		this.name = name;
		this.times = times;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timings getTimes() {
		return times;
	}

	public void setTimes(Timings times) {
		this.times = times;
	}

}
