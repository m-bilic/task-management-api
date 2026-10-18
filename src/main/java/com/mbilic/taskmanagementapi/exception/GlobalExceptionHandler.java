package com.mbilic.taskmanagementapi.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleInvalidRequestArguments (
			MethodArgumentNotValidException ex) {
		
		String message = ex.getAllErrors().stream()
				.map(e -> e.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
		return new ResponseEntity<>("Invalid input: " 
			+ message, 
			HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<String> handleNotFoundException (
			TaskNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(),
				HttpStatus.NOT_FOUND);
	}
}
