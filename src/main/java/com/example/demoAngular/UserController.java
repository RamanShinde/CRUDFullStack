package com.example.demoAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/msg")
	String message() {
		return "Welcome To Angular App";
	}

	@PostMapping("/add-user")
	ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		Optional<User> existingUser = service.getEmail(user.getEmail());

		if (existingUser.isPresent()) {
			return ResponseEntity.badRequest().body("Email already exists!!");
		}
		service.addUser(user);
		return ResponseEntity.ok("Add succesfully!!");
	}

	@GetMapping("/get-user")
	List<User> getAllUser() {
		return service.getAllUser();
	}

	@DeleteMapping("/delete-user-{id}")
	String deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return "Delete Succesfully!!";
	}

	@PutMapping("/update-user-{id}")
	String updateUser(@PathVariable Long id, @RequestBody User user) {
		service.updateUser(id, user);
		return "Update Successfully!!";
	}

	@GetMapping("/get-userEmail")
	Optional<User> getEmail(@RequestParam String email) {
		return service.getEmail(email);
	}
}
