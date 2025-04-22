package com.example.demoAngular;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {
	   @ExceptionHandler(MethodArgumentNotValidException.class)
       public ResponseEntity<Map<String, String>> validationExecption(MethodArgumentNotValidException ex){
		   Map<String, String>errors=new HashMap<String, String>();
		   ex.getBindingResult().getAllErrors().forEach(error -> {
	            if (error instanceof FieldError) {
	                FieldError fieldError = (FieldError) error;   
	                errors.put(fieldError.getField(), fieldError.getDefaultMessage());   
	            }
	        });
		   return ResponseEntity.badRequest().body(errors);
       }
}