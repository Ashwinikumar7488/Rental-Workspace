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
import com.ty.rentalworkspaceproject.dto.Workspace;
import com.ty.rentalworkspaceproject.service.WorkspaceService;
import com.ty.rentalworkspaceproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/workspaces")
@RestController
public class WorkspaceController {

	@Autowired
	private WorkspaceService workspaceService;

	@ApiOperation(value = "Save Workspace", notes = "This API is to save the Workspace")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PostMapping()
	public ResponseEntity<ResponseStructure<Workspace>> saveWorkspace(@RequestBody Workspace workspace) {
		return workspaceService.saveWorkspace(workspace);
	}

	@ApiOperation(value = "Update Workspace", notes = "This API is to update the Workspace details by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UPDATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PatchMapping("/{id}")
	public ResponseEntity<ResponseStructure<Workspace>> updateWorkspace(@PathVariable int id,
			@RequestBody Workspace workspace) {
		return workspaceService.updateWorkspace(id, workspace);
	}

	@ApiOperation(value = "Get All Workspaces", notes = "This API is to get all the Workspace details ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping("/get_all")
	public ResponseEntity<ResponseStructure<List<Workspace>>> getAll() {
		return workspaceService.getAll();
	}

	@ApiOperation(value = "Get Workspace", notes = "This API is to get the Workspace details by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Workspace>> getWorkspaceById(@PathVariable int id) {
		return workspaceService.getWorkspaceById(id);
	}

	@ApiOperation(value = "Delete Workspace ", notes = "This API is to delete the Workspace by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "DELETED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteWorkspace(@PathVariable int id) {
		return workspaceService.deleteWorkspace(id);
	}
}