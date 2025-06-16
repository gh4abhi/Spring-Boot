package com.revision.crud.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revision.crud.entity.AnimeErrorResponse;
import com.revision.crud.exception.AnimeNotFoundException;

@ControllerAdvice
public class AnimeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<AnimeErrorResponse> handleException(AnimeNotFoundException ex) {
		AnimeErrorResponse error = new AnimeErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setMessage(ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	// To catch any exception

	@ExceptionHandler
	public ResponseEntity<AnimeErrorResponse> handleException(Exception ex) {
		AnimeErrorResponse error = new AnimeErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
