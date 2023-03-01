package com.ty.rentalworkspaceproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.rentalworkspaceproject.dao.WorkspaceDao;
import com.ty.rentalworkspaceproject.dto.Workspace;
import com.ty.rentalworkspaceproject.exceptions.IdNotFoundException;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

@Service
public class WorkspaceService {

	@Autowired
	private WorkspaceDao workspaceDao;

	public ResponseEntity<ResponseStructure<Workspace>> saveWorkspace(Workspace workspace) {
		ResponseStructure<Workspace> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(workspaceDao.saveWorkspace(workspace));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Workspace>> getWorkspaceById(int id) {
		Optional<Workspace> opt = workspaceDao.getWorkspaceById(id);
		ResponseStructure<Workspace> responseStructure = new ResponseStructure<>();
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

	public ResponseEntity<ResponseStructure<List<Workspace>>> getAll() {
		ResponseStructure<List<Workspace>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(workspaceDao.getAll());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteWorkspace(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		Optional<Workspace> opt = workspaceDao.getWorkspaceById(id);
		if (opt.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("DATA DELETED SUCCESSFULLY!");
			workspaceDao.deleteWorkspace(id);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("ID Not Found!");
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Workspace>> updateWorkspace(int id, Workspace workspace) {
		Optional<Workspace> opt = workspaceDao.getWorkspaceById(id);
		if (opt.isPresent()) {
			Workspace ret = opt.get();
			ret.setName(workspace.getName());
			ret.setAddress(workspace.getAddress());
			ret.setContactNo(workspace.getContactNo());
			ret.setBooking(workspace.getBooking());
			ResponseStructure<Workspace> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(workspaceDao.saveWorkspace(ret));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given ID " + id + " doesn't exist!");
		}
	}
}
