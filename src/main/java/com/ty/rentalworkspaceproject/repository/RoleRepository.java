package com.ty.rentalworkspaceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.rentalworkspaceproject.dto.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
