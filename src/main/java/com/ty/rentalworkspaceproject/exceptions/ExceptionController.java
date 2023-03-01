package com.ty.rentalworkspaceproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.rentalworkspaceproject.util.ResponseStructure;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> HandleIdNotFoundException(IdNotFoundException e) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not found");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> HandleInvalidCredentialException(InvalidCredentialException e) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Invalid credentials");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
	}
}
