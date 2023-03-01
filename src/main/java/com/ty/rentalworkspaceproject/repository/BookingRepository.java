package com.ty.rentalworkspaceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.rentalworkspaceproject.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
