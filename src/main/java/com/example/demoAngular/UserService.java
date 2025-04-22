package com.example.demoAngular;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepo repo;
	public void addUser(User user) {
		 repo.save(user);
	}
	public List<User> getAllUser() {
		return repo.findAll();
	}
	public void deleteUser(Long id) {
		User user=repo.findById(id).orElseThrow(()-> new RuntimeException("Student not found!!!"));
		repo.delete(user);
	}
	public void updateUser(Long id, User user) {
	  User exitsingUser=repo.findById(id).orElseThrow(()-> new RuntimeException("User not found!!"));
	  exitsingUser.setName(user.getName());
	  exitsingUser.setEmail(user.getEmail());
	  exitsingUser.setPassword(user.getPassword());
	  exitsingUser.setPhonenumber(user.getPhonenumber());
	  
	  repo.save(exitsingUser);
	}
	public Optional<User> getEmail(String email) {
		return repo.findByEmail(email);
	}
}  