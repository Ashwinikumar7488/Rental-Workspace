package com.ty.rentalworkspaceproject.exceptions;

public class InvalidCredentialsException extends RuntimeException  {
	String message = "InvalidCredentials";

	public InvalidCredentialsException() {

	}

	public InvalidCredentialsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
