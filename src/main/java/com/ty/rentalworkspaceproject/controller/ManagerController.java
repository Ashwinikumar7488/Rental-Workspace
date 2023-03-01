package com.ty.rentalworkspaceproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ty.rentalworkspaceproject.dto.Login;
import com.ty.rentalworkspaceproject.dto.Manager;
import com.ty.rentalworkspaceproject.service.ManagerService;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/managers")
@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@ApiOperation(value = "Save Manager", notes = "This API is to save the Manager")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PostMapping()
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@ApiOperation(value = "Update Manager", notes = "This API is to update the Manager details by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UPDATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PatchMapping("/{id}")
	public ResponseEntity<ResponseStructure<Manager>> updateManager(@PathVariable int id,
			@RequestBody Manager manager) {
		return managerService.updateManager(id, manager);
	}

	@ApiOperation(value = "Get All Managers", notes = "This API is to get all the Manager details ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Manager>>> getAll() {
		return managerService.getAll();
	}

	@ApiOperation(value = "Get Manager", notes = "This API is to get the Manager details by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Manager>> getManagerById(@PathVariable int id) {
		return managerService.getManagerById(id);
	}

	@ApiOperation(value = "Delete Manager ", notes = "This API is to delete the Manager by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "DELETED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteManager(@PathVariable int id) {
		return managerService.deleteManager(id);
	}

	@ApiOperation(value = "Validate Manager ", notes = "This API is to validate the Manager by email and password")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "DELETED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PostMapping("/manager/{login}")
	public ResponseEntity<ResponseStructure<Manager>> validationByEmailAndPassword(@RequestBody Login login) {
		return managerService.validationByEmailAndPassword(login);
	}
}
