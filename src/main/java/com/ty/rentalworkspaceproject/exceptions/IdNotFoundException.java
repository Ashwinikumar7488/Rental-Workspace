package com.ty.rentalworkspaceproject.exceptions;

public class IdNotFoundException extends RuntimeException {
	String message = "Given ID is not found";

	public IdNotFoundException() {

	}

	public IdNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}