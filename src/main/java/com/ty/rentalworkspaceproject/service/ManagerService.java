package com.ty.rentalworkspaceproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.rentalworkspaceproject.dao.ManagerDao;
import com.ty.rentalworkspaceproject.dto.Login;
import com.ty.rentalworkspaceproject.dto.Manager;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.exceptions.InvalidCredentialsException;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@Service
public class ManagerService {

	@Autowired
	private ManagerDao managerDao;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> getManagerById(int id) {
		Optional<Manager> opt = managerDao.getManagerById(id);
		ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
		if (opt.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(opt.get());
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("ID Not Found!");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Manager>>> getAll() {
		ResponseStructure<List<Manager>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(managerDao.getAll());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteManager(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		Optional<Manager> opt = managerDao.getManagerById(id);
		if (opt.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("DATA DELETED SUCCESSFULLY!");
			managerDao.deleteManager(id);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("ID Not Found!");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> updateManager(int id, Manager manager) {
		Optional<Manager> opt = managerDao.getManagerById(id);
		if (opt.isPresent()) {
			Manager ret = opt.get();
			ret.setUsername(manager.getUsername());
			ret.setPassword(manager.getPassword());
			ret.setEmail(manager.getEmail());
			ret.setPhone(manager.getPhone());
			ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(managerDao.saveManager(ret));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given ID " + id + " doesn't exist!");
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> validationByEmailAndPassword(Login login) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<>();
		Manager manager = managerDao.validationByEmailAndPassword(login.getEmail(), login.getPassword());
		if (manager != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(manager);
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("Invalid credetionals for email:" + login.getEmail());
		}

	}
}
