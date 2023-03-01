package com.ty.rentalworkspaceproject.workspace_test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ty.rentalworkspaceproject.dto.Workspace;
import com.ty.rentalworkspaceproject.repository.WorkspaceRepository;

@SpringBootTest
public class GetWorkspaceByIdTest {

	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Test
	@Transactional
	@Rollback(true)
	public void testGetWorkspaceById() {
		Optional<Workspace> opt = workspaceRepository.findById(1);
		assertNotNull(opt);
	}
}
