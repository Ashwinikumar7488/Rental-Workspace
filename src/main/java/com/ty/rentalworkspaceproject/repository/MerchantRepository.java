package com.ty.rentalworkspaceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.rentalworkspaceproject.dto.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

	public Merchant findByEmailAndPassword(String email, String password);
	
}