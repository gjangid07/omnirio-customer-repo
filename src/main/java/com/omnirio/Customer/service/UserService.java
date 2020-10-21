package com.omnirio.Customer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.Customer.model.User;
import com.omnirio.Customer.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	public User findByUserName(String userName) {
		List<User> users = userRepository.findAll();

		users = users.stream().filter(i -> userName.equals(i.getUserName())).collect(Collectors.toList());

		return users.get(0);
	}

	public User insertUser(User User) {
		return userRepository.save(User);
	}

	public User updatingUser(User User) {
		return userRepository.save(User);
	}

	public void deleteUserById(int id) {
		userRepository.deleteById(id);

	}
}
