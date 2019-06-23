package com.model;

public class Response {
	int id;
	Timings timing;

	public Response(int id, Timings timing) {
		super();
		this.id = id;
		this.timing = timing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timings getTiming() {
		return timing;
	}

	public void setTiming(Timings timing) {
		this.timing = timing;
	}

}
