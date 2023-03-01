package com.ty.rentalworkspaceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.rentalworkspaceproject.dto.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	public Manager findByEmailAndPassword(String email, String password);
}
