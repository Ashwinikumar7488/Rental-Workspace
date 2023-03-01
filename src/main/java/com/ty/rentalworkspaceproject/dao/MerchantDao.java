package com.ty.rentalworkspaceproject.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.rentalworkspaceproject.dto.Merchant;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.repository.MerchantRepository;

@Repository
public class MerchantDao {
	@Autowired
	MerchantRepository merchantRepository;

	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);

	}

	public Merchant updateMerchant(int id, Merchant merchant) {
		Optional<Merchant> opt = merchantRepository.findById(id);
		if (opt.isPresent()) {
			Merchant m = opt.get();
			m.setFirstname(merchant.getFirstname());
			m.setLastname(merchant.getLastname());
			m.setEmail(merchant.getEmail());
			m.setPassword(merchant.getPassword());
			return m;
		} else
			throw new IdNotFoundException(id + "id not found");

	}

	public Optional<Merchant> getMerchantById(int id) {
		return merchantRepository.findById(id);
	}

	public List<Merchant> getAllMerchant() {
		return merchantRepository.findAll();
	}

	public String delete(int id) {
		Optional<Merchant> opt = merchantRepository.findById(id);
		if (opt.isPresent()) {
			merchantRepository.delete(opt.get());
			return "Merchant is deleted";
		} else
			return "invalid id";
	}

	public Merchant validationByEmailAndPassword(String email, String password) {

		return merchantRepository.findByEmailAndPassword(email, password);
	}

}
