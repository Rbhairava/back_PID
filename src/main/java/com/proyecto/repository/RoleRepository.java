package com.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Role;
import com.proyecto.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRoleName(RoleName roleName);
}
