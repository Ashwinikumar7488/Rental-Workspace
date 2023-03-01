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
import com.ty.rentalworkspaceproject.dto.Admin;
import com.ty.rentalworkspaceproject.service.AdminService;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping("/admins")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Validated @RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@PutMapping("/admins/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

	@DeleteMapping("/admins/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@PathVariable int id) {
		return adminService.deleteAdmin(id);
	}

	@GetMapping("/admins/{id}")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANAGER"})
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int id) {
		return adminService.getById(id);
	}

	@GetMapping("/admins")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANAGER", "ROLE_MERCHANT"})
	public ResponseEntity<ResponseStructure<Admin>> getAllAdmin() {
		return adminService.getAllAdmin();
	}
//	@PostMapping("/admins")
//	public ResponseEntity<ResponseStructure<Admin>> validationById(@RequestParam Login login) {
//	return adminService.findByEmailAndPassword(login);
//	}
}
