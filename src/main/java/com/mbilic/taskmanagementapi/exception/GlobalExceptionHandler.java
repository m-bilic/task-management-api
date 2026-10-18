package com.mbilic.taskmanagementapi.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mbilic.taskmanagementapi.model.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleInvalidRequestArguments (
			MethodArgumentNotValidException ex) {
		
		String message = ex.getAllErrors().stream()
				.map(e -> e.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
		return new ResponseEntity<>(new ErrorResponseDto(
				HttpStatus.BAD_REQUEST.value(),
				message), 
			HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleNotFoundException (
			TaskNotFoundException ex) {
		return new ResponseEntity<>(
				new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), 
						ex.getMessage()),
				HttpStatus.NOT_FOUND);
	}
}
