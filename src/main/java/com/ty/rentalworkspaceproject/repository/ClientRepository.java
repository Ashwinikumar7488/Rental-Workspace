package com.ty.rentalworkspaceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.rentalworkspaceproject.dto.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	public Client findByEmailAndPassword(String email, String password);
}
