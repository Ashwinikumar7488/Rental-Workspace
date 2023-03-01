package com.ty.rentalworkspaceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.rentalworkspaceproject.dto.Login;
import com.ty.rentalworkspaceproject.dto.Merchant;
import com.ty.rentalworkspaceproject.service.MerchantService;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@RestController
public class MerchantController {
	@Autowired
	MerchantService merchantService;

	@PostMapping("/merchant")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@Validated @RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}

	@PutMapping("/merchant")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@PathVariable int id,
			@RequestBody Merchant merchant) {
		return merchantService.updateMerchant(id, merchant);
	}

	@DeleteMapping("/merchant/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> deleteMerchant(@PathVariable int id) {
		return merchantService.deleteMerchant(id);
	}

	@GetMapping("/merchant/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> getMerchantrById(@PathVariable int id) {
		return merchantService.getById(id);
	}

	@GetMapping("/merchant")
	public ResponseEntity<ResponseStructure<Merchant>> getAllMerchantt() {
		return merchantService.getAllMerchant();
	}

	@PostMapping("/merchant/{login}")
	public ResponseEntity<ResponseStructure<Merchant>> validationByEmailAndPassword(@RequestBody Login login) {
		return merchantService.validationByEmailAndPassword(login);
	}
}
