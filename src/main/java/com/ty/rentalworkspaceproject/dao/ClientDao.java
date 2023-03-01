package com.ty.rentalworkspaceproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.rentalworkspaceproject.dto.Client;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.repository.ClientRepository;

@Repository
public class ClientDao {
	@Autowired
	ClientRepository clientRepository;

	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	public Client UpdateClient(int id, Client client) {
		Optional<Client> opt = clientRepository.findById(id);
		if (opt.isPresent()) {
			Client c = opt.get();
			c.setFirstname(client.getFirstname());
			c.setLastname(client.getLastname());
			c.setEmail(client.getEmail());
			c.setPassword(client.getPassword());
			return c;
		} else
			throw new IdNotFoundException(id + "id not found");

	}

	public Optional<Client> getClientById(int id) {
		return clientRepository.findById(id);
	}

	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	public String DeleteClient(int id) {
		Optional<Client> opt = clientRepository.findById(id);
		if (opt.isPresent()) {
			clientRepository.delete(opt.get());
			return "Clent is deleted";
		} else
			return "invalid id";
	}

	public Client validationByEmailAndPassword(String email, String password) {

		return clientRepository.findByEmailAndPassword(email, password);
	}

}
