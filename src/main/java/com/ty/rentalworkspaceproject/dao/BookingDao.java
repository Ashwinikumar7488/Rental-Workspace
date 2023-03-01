package com.ty.rentalworkspaceproject.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.rentalworkspaceproject.dto.Booking;
import com.ty.rentalworkspaceproject.repository.BookingRepository;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepository bookingRepository;

	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Optional<Booking> getBookingById(int id) {
		return bookingRepository.findById(id);
	}

	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	public void deleteBooking(int id) {
		Optional<Booking> opt = bookingRepository.findById(id);
		bookingRepository.delete(opt.get());
	}

	public Booking updateBooking(int id, Booking booking) {
		return bookingRepository.save(booking);
	}
}
