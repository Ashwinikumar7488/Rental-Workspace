package com.ty.rentalworkspaceproject.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.rentalworkspaceproject.dto.Manager;
import com.ty.rentalworkspaceproject.repository.ManagerRepository;

@Repository
public class ManagerDao {

	@Autowired
	private ManagerRepository managerRepository;

	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}

	public Optional<Manager> getManagerById(int id) {
		return managerRepository.findById(id);
	}

	public List<Manager> getAll() {
		return managerRepository.findAll();
	}

	public void deleteManager(int id) {
		Optional<Manager> opt = managerRepository.findById(id);
		managerRepository.delete(opt.get());
	}

	public Manager updateManager(int id, Manager manager) {
		return managerRepository.save(manager);
	}

	public Manager validationByEmailAndPassword(String email, String password) {

		return managerRepository.findByEmailAndPassword(email, password);
	}
}
