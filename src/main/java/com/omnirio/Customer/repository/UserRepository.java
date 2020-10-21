package com.omnirio.Customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnirio.Customer.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findById(Integer id);

}
