package com.ty.rentalworkspaceproject.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ty.rentalworkspaceproject.dto.Client;
import com.ty.rentalworkspaceproject.dto.Login;
import com.ty.rentalworkspaceproject.service.ClientService;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping("/clients")
	@RolesAllowed("ROLE_CLIENT")
	public ResponseEntity<ResponseStructure<Client>> saveClient(@Validated @RequestBody Client client) {
		return clientService.saveClient(client);
	}

	@PutMapping("/clients")
	public ResponseEntity<ResponseStructure<Client>> updateClient(@PathVariable int id, @RequestBody Client client) {
		return clientService.updateClient(id, client);
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<ResponseStructure<Client>> deleteClient(@PathVariable int id) {
		return clientService.deleteClient(id);
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<ResponseStructure<Client>> getClientById(@PathVariable int id) {
		return clientService.getById(id);
	}

	@GetMapping("/clients")
	public ResponseEntity<ResponseStructure<Client>> getAllClient() {
		return clientService.getAllClient();
	}
//@PostMapping("/clients")
//public ResponseEntity<ResponseStructure<Client>> validationById(@RequestParam int id) {
//return clientService.validationById(id);
//}

}
