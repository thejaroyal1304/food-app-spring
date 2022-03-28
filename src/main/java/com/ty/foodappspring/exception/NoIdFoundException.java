package com.ty.foodappspring.exception;

public class NoIdFoundException extends RuntimeException {
	private String msg = "Id not found";

	private NoIdFoundException() {

	}

	public NoIdFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
