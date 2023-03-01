package com.ty.rentalworkspaceproject.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.rentalworkspaceproject.dto.Workspace;
import com.ty.rentalworkspaceproject.repository.WorkspaceRepository;

@Repository
public class WorkspaceDao {

	@Autowired
	private WorkspaceRepository workspaceRepository;

	public Workspace saveWorkspace(Workspace workspace) {
		return workspaceRepository.save(workspace);
	}

	public Optional<Workspace> getWorkspaceById(int id) {
		return workspaceRepository.findById(id);
	}

	public List<Workspace> getAll() {
		return workspaceRepository.findAll();
	}

	public void deleteWorkspace(int id) {
		Optional<Workspace> opt = workspaceRepository.findById(id);
		workspaceRepository.delete(opt.get());
	}

	public Workspace updateWorkspace(int id, Workspace workspace) {
		return workspaceRepository.save(workspace);
	}
}
