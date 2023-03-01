package com.ty.rentalworkspaceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.rentalworkspaceproject.dto.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {

}
