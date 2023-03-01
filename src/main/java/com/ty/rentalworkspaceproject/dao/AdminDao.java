package com.ty.rentalworkspaceproject.dao;

import org.springframework.stereotype.Repository;
import com.ty.rentalworkspaceproject.dto.Admin;
import com.ty.rentalworkspaceproject.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Optional<Admin> getAdminById(int id) {
		return adminRepository.findById(id);
	}

	public Optional<Admin> updateAdmin(int id) {
		return adminRepository.findById(id);
	}

	public Admin findByEmailAndPassword(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);

	}

	public List<Admin> getallAdmin() {

		return adminRepository.findAll();
	}

	public void deleteAdmin(int id) {
		Optional<Admin> opt = adminRepository.findById(id);
		adminRepository.delete(opt.get());
	}

}