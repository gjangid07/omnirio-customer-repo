package com.omnirio.Customer.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.omnirio.Customer.model.User;
import com.omnirio.Customer.model.Role;
import com.omnirio.Customer.repository.UserRepository;
import com.omnirio.Customer.service.UserService;

@RestController
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) throws Exception {
		Optional<User> user = userService.findById(id);

		if (!user.isPresent())
			throw new Exception("User not found with id-" + id);
		User usr = user.get();
		usr.getRole().setUser(null);
		usr.getRole().setUsrId(usr.getUserId());

		return usr;
	}

	@GetMapping("/user/{userName}")
	public User getUserByUserName(@PathVariable String userName) throws Exception {
		User user = userService.findByUserName(userName);

		if (user == null)
			throw new Exception("User not found with userName-" + userName);

		user.getRole().setUser(null);
		user.getRole().setUsrId(user.getUserId());

		return user;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUserById(id);
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		Role role = user.role;
		role.setUser(user);
		User savedUser = userService.insertUser(user);
		savedUser.getRole().setUsrId(savedUser.getUserId());
		savedUser.getRole().setUser(null);
		return ResponseEntity.ok(savedUser);

	}
}
