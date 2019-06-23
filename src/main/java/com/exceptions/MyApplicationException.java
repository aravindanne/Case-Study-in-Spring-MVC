package com.exceptions;

public class MyApplicationException extends RuntimeException {
	private int id;
	private static final long serialVersionUID = 5919195046942029719L;

	public MyApplicationException(String message) {
		super(message);
	}

	public MyApplicationException(int id, String message) {
		super(message);
		this.id = id;
	}

	public MyApplicationException(String message, Throwable e) {
		super(message, e);
	}

	public MyApplicationException(int id, String message, Throwable e) {
		super(message, e);
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
