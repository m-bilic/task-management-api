package com.mbilic.taskmanagementapi.exception;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mbilic.taskmanagementapi.model.dto.ErrorDto;
import com.mbilic.taskmanagementapi.model.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleInvalidRequestArguments (
			MethodArgumentNotValidException ex) {
		
		List<ErrorDto> errors = ex.getFieldErrors().stream()
				.map(e -> new ErrorDto(e.getField(),
						e.getDefaultMessage()))
				.toList();
		
		return new ResponseEntity<>(new ErrorResponseDto(
				HttpStatus.BAD_REQUEST.value(),
				"Invalid request",
				errors), 
			HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleNotFoundException (
			ResourceNotFoundException ex) {
		return new ResponseEntity<>(
				new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), 
						ex.getMessage(),
						null),
				HttpStatus.NOT_FOUND);
	}
}
