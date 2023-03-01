package com.ty.rentalworkspaceproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.rentalworkspaceproject.dao.BookingDao;
import com.ty.rentalworkspaceproject.dto.Booking;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking) {
		ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(bookingDao.saveBooking(booking));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int id) {
		Optional<Booking> opt = bookingDao.getBookingById(id);
		ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
		if (opt.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(opt.get());
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("ID Not Found!");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> getAll() {
		ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(bookingDao.getAll());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteBooking(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		Optional<Booking> opt = bookingDao.getBookingById(id);
		if (opt.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("DATA DELETED SUCCESSFULLY!");
			bookingDao.deleteBooking(id);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("ID Not Found!");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> updateBooking(int id, Booking booking) {
		Optional<Booking> opt = bookingDao.getBookingById(id);
		if (opt.isPresent()) {
			Booking ret = opt.get();
			ret.setBookingTime(booking.getBookingTime());
			ret.setBookingDuration(booking.getBookingDuration());
			ret.setBookingCost(booking.getBookingCost());
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(bookingDao.saveBooking(ret));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given ID " + id + " doesn't exist!");
		}
	}
}
