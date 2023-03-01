package com.ty.rentalworkspaceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.rentalworkspaceproject.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByEmailAndPassword(String email, String password);
}
