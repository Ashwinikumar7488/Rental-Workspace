package com.ty.rentalworkspaceproject.workspace_test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.ty.rentalworkspaceproject.dto.Role;
import com.ty.rentalworkspaceproject.dto.User;
import com.ty.rentalworkspaceproject.repository.UserRepository;
import lombok.Data;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@Data
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;

//	@Test
//	public void testCreateUser() {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String password = passwordEncoder.encode("Dny012");
//
//		User newUser = new User("danny@gmail.com", password);
//		User savedUser = repo.save(newUser);
//
//		assertThat(savedUser).isNotNull();
//		assertThat(savedUser.getId()).isGreaterThan(0);
//	}
	
	@Test
	public void testAssignRoleToUser() {
	    Integer userId = 9;
	    Integer roleId1 = 1;
	    Integer roleId2 = 2;
	    Integer roleId3 = 3;
	    
	    User user = repo.findById(userId).get();
	    user.addRole(new Role(roleId1));
	    user.addRole(new Role(roleId2));
	    user.addRole(new Role(roleId3));
	    
	    User updatedUser = repo.save(user);
	    assertThat(updatedUser.getRoles()).hasSize(3);
	     
	}
	
//	@Test
//	public void testAssignRoleToUser() {
//	    Integer userId = 2;
//	    User user = repo.findById(userId).get();
//	    user.addRole(new Role(1));
//	user.addRole(new Role(2));
//	 
//	     
//	    User updatedUser = repo.save(user);
//	    assertThat(updatedUser.getRoles()).hasSize(2);
//	     
//	}

}