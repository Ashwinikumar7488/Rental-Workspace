package com.ty.rentalworkspaceproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ty.rentalworkspaceproject.dto.Booking;
import com.ty.rentalworkspaceproject.service.BookingService;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@ApiOperation(value = "Save Booking", notes = "This API is to save the Booking")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PostMapping("/bookings")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}

	@ApiOperation(value = "Update Booking", notes = "This API is to update the Booking details by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UPDATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PatchMapping("/bookings/{id}")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@PathVariable int id,
			@RequestBody Booking booking) {
		return bookingService.updateBooking(id, booking);
	}

	@ApiOperation(value = "Get All Bookings", notes = "This API is to get all the Booking details ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping("/bookings")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAll() {
		return bookingService.getAll();
	}

	@ApiOperation(value = "Get Booking", notes = "This API is to get the Booking details by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping("/bookings/{id}")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@PathVariable int id) {
		return bookingService.getBookingById(id);
	}

	@ApiOperation(value = "Delete Booking ", notes = "This API is to delete the Booking by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "DELETED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBooking(@PathVariable int id) {
		return bookingService.deleteBooking(id);
	}

}