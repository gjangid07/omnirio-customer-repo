package com.omnirio.Customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnirio.Customer.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	public Optional<Role> findById(Integer id);

}
