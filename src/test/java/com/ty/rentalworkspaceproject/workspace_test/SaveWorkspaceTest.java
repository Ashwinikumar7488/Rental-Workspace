package com.ty.rentalworkspaceproject.workspace_test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ty.rentalworkspaceproject.dto.Workspace;
import com.ty.rentalworkspaceproject.repository.WorkspaceRepository;

@SpringBootTest
public class SaveWorkspaceTest {

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSaveWorkspace() {
		Workspace workspace = new Workspace();
		workspace.setId(3);
		workspace.setName("IndiQube");
		workspace.setAddress("Kolkata");
		workspace.setContactNo("9876543210");
		Workspace workspace2 = workspaceRepository.save(workspace);
		assertNotNull(workspace2);
	}
}
