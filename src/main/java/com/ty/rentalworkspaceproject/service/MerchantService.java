package com.ty.rentalworkspaceproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.rentalworkspaceproject.dao.MerchantDao;
import com.ty.rentalworkspaceproject.dto.Login;
import com.ty.rentalworkspaceproject.dto.Merchant;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.exceptions.InvalidCredentialsException;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@Service
public class MerchantService {
	@Autowired
	MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant Merchant) {
		ResponseStructure<Merchant> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESSFULLY CREATED");
		responseStructure.setData(merchantDao.saveMerchant(Merchant));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> deleteMerchant(int id) {
		ResponseStructure<Merchant> responseStructure = new ResponseStructure<Merchant>();
		Optional<Merchant> merchant = merchantDao.getMerchantById(id);
		if (merchant.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(merchant.get());
			merchantDao.delete(id);
			return new ResponseEntity<ResponseStructure<Merchant>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("id" + id + "does not exists");
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> validationByEmailAndPassword(Login login) {
		ResponseStructure<Merchant> responseStructure = new ResponseStructure<>();
		Merchant merchant = merchantDao.validationByEmailAndPassword(login.getEmail(), login.getPassword());
		if (merchant != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(merchant);
			return new ResponseEntity<ResponseStructure<Merchant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("Invalid credetionals for email:" + login.getEmail());
		}

	}

	public ResponseEntity<ResponseStructure<Merchant>> getById(int id) {
		Optional<Merchant> opt = merchantDao.getMerchantById(id);
		if (opt.isPresent()) {
			Merchant merchant = opt.get();
			ResponseStructure<Merchant> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(merchant);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("ID " + id + " does not exist");
	}

	public ResponseEntity<ResponseStructure<Merchant>> getAllMerchant() {
		List<Merchant> merchant = merchantDao.getAllMerchant();
		ResponseStructure<List<Merchant>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(merchant);
		return new ResponseEntity<ResponseStructure<Merchant>>(HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(int id, Merchant merchant) {
		Optional<Merchant> opt = merchantDao.getMerchantById(id);
		if (opt.isPresent()) {
			Merchant merchant1 = opt.get();
			merchant1.setFirstname(merchant.getFirstname());
			merchant1.setLastname(merchant.getLastname());
			merchant1.setEmail(merchant.getEmail());
			merchant1.setPassword(merchant.getPassword());

			ResponseStructure<Merchant> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(merchant);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("ID " + id + " does not exist");
		}

	}


	

}
