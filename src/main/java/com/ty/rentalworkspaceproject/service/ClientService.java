package com.ty.rentalworkspaceproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.rentalworkspaceproject.dao.ClientDao;
import com.ty.rentalworkspaceproject.dto.Client;
import com.ty.rentalworkspaceproject.dto.Login;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.exceptions.InvalidCredentialsException;
import com.ty.rentalworkspaceproject.util.ResponseStructure;
@Service
public class ClientService {
	@Autowired
	ClientDao clientDao;

	public ResponseEntity<ResponseStructure<Client>> saveClient(Client client) {
		ResponseStructure<Client> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESSFULLY CREATED");
		responseStructure.setData(clientDao.saveClient(client));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Client>> deleteClient(int id) {
		ResponseStructure<Client> responseStructure = new ResponseStructure<Client>();
		 Optional<Client> client =clientDao.getClientById(id);
		if (client.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(client.get());
			clientDao.DeleteClient(id);
			return new ResponseEntity<ResponseStructure<Client>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("id" + id + "does not exists");
		}
	}

	public ResponseEntity<ResponseStructure<Client>> validationByEmailAndPassword(Login login) {
		ResponseStructure<Client> responseStructure = new ResponseStructure<>();
		Client client = clientDao.validationByEmailAndPassword(login.getEmail(), login.getPassword());
		if (client != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(client);
			return new ResponseEntity<ResponseStructure<Client>>(HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("Invalid credetionals for email:" + login.getEmail());
		}

	}

	public ResponseEntity<ResponseStructure<Client>> getById(int id) {
		Optional<Client> opt =clientDao.getClientById(id);
		if (opt.isPresent()) {
			Client client = opt.get();
			ResponseStructure<Client> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(client);
			return new ResponseEntity<ResponseStructure<Client>>(HttpStatus.OK);
		} else
			throw new IdNotFoundException("ID " + id + " does not exist");
	}

	public ResponseEntity<ResponseStructure<Client>> getAllClient() {
		List<Client> client = clientDao.getAllClient();
		ResponseStructure<List<Client>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(client);
		return new ResponseEntity<ResponseStructure<Client>>(HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Client>> updateClient(int id,Client client1) {
		Optional<Client> opt = clientDao.getClientById(id);
		if (opt.isPresent()) {
			Client client = opt.get();
			client.setFirstname(client1.getFirstname());
			client.setLastname(client1.getLastname());
			client.setEmail(client1.getEmail());
			client.setPassword(client1.getPassword());

			ResponseStructure<Client> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(client);
			return new ResponseEntity<ResponseStructure<Client>>(HttpStatus.OK);
		} else {
			throw new IdNotFoundException("ID " + id + " does not exist");
		}

	}

}
