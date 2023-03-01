package com.ty.rentalworkspaceproject.exceptions;

public class InvalidCredentialException extends RuntimeException {
	private String message = "Invalid credential";
	
	
	public InvalidCredentialException() {

	}

	public InvalidCredentialException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}