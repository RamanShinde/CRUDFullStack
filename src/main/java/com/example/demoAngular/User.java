package com.example.demoAngular;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(nullable = false)
	 @NotEmpty(message="Name is required")
	 private String name;
	 @Column(nullable=false,unique=true)
	 @NotEmpty(message="Email is required")
	 @Email(message="Email is not valid")
	 private String email;
	 @Column(nullable=false)
	 @NotEmpty(message="Phonenumbe is reuired")
	 @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
	 private String phonenumber;
	 @Column(nullable=false)
	 @NotEmpty(message="Password is reuired")
	 private String password;
//	 @Column(nullable=false)
//	 private String message;
	  
}