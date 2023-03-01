package com.ty.rentalworkspaceproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.rentalworkspaceproject.dao.AdminDao;
import com.ty.rentalworkspaceproject.dto.Admin;
import com.ty.rentalworkspaceproject.dto.Client;
import com.ty.rentalworkspaceproject.dto.Login;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {

		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setData(adminDao.saveAdmin(admin));

		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id, Admin admin) {
		Optional<Admin> optional = adminDao.getAdminById(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfull Update");
			Admin admin1 = optional.get();
			admin1.setUsername(admin.getUsername());
			admin1.setPassword(admin.getPassword());
			admin1.setAcc_type(admin.getAcc_type());
			admin1.setEmail(admin.getEmail());
			admin1.setPhoneNo(admin.getPhoneNo());
			responseStructure.setData(adminDao.saveAdmin(admin));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Admin id:" + id + "is not exist");
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> findByEmailAndPassword(Login login) {
		Admin admin = adminDao.findByEmailAndPassword(login.getEmail(), login.getPassword());
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Id And Password FOUND");
		responseStructure.setData(admin);
		return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);

	}
	public ResponseEntity<ResponseStructure<Admin>> getById(int id) {
		Optional<Admin> opt =adminDao.getAdminById(id);
		if (opt.isPresent()) {
			Admin admin = opt.get();
			ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(HttpStatus.OK);
		} else
			throw new IdNotFoundException("ID " + id + " does not exist");
	}

	public ResponseEntity<ResponseStructure<Admin>> getAllAdmin() {
		List<Admin> admin = adminDao.getallAdmin();
		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(admin);
		return new ResponseEntity<ResponseStructure<Admin>>(HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		 Optional<Admin> admin =adminDao.getAdminById(id);
		if (admin.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(null);
			adminDao.deleteAdmin(id);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("id" + id + "does not exists");
		}
	}
}
