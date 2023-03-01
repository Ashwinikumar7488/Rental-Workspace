package com.ty.rentalworkspaceproject.workspace_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.ty.rentalworkspaceproject.dto.Role;
import com.ty.rentalworkspaceproject.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	@Autowired
	private RoleRepository repo;

	@Test
	public void testCreateRoles() {
		Role admin = new Role("ROLE_ADMIN");
		Role manager = new Role("ROLE_MANAGER");
		Role merchant = new Role("ROLE_MERCHANT");
		Role client = new Role("ROLE_CLIENT");

		repo.saveAll(List.of(admin, manager, merchant, client));

		long count = repo.count();
		assertEquals(4, count);
	}
}