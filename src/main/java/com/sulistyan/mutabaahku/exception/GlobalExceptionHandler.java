package com.sulistyan.mutabaahku.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(com.sulistyan.mutabaahku.exception.ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(com.sulistyan.mutabaahku.exception.ResourceNotFoundException ex, WebRequest request) {
		com.sulistyan.mutabaahku.exception.ErrorDetails errorDetails = new com.sulistyan.mutabaahku.exception.ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		com.sulistyan.mutabaahku.exception.ErrorDetails errorDetails = new com.sulistyan.mutabaahku.exception.ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
