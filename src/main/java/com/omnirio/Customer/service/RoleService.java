package com.omnirio.Customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.Customer.model.Role;
import com.omnirio.Customer.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}
	
	public Role insertRole(Role Role) {
		return roleRepository.save(Role);
	}

	public Role updatingRole(Role Role) {
		return roleRepository.save(Role);
	}

	public void deleteRoleById(int id) {
		roleRepository.deleteById(id);
		
	}
}
