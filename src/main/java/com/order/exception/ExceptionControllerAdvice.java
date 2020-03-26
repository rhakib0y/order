package com.order.exception;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.order.access.model.ErrorResponse;
import com.order.constant.ResponseMessage;

@ControllerAdvice
public class ExceptionControllerAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exception(Exception e) {
		HttpStatus status = HttpStatus.CONFLICT;
		LOGGER.error(e.getLocalizedMessage(), e);
		return new ResponseEntity<>(new ErrorResponse(ResponseMessage.SOMETHING_WENT_WRONG), status);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> exception(MethodArgumentNotValidException e) {
		String msg = e.getBindingResult().getFieldError().getDefaultMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(new ErrorResponse(msg), status);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(EntityNotFoundException e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		LOGGER.error(e.getLocalizedMessage(), e);
		return new ResponseEntity<>(new ErrorResponse(ResponseMessage.RECORD_NOT_FOUND), status);
	}
	@ExceptionHandler(InvalidDataFormatException.class)
	public ResponseEntity<ErrorResponse> exception(InvalidDataFormatException e) {
		String msg = e.getErrorMsg();
		HttpStatus status = e.getHttpStatus();
		return new ResponseEntity<>(new ErrorResponse(msg), status);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ErrorResponse> exception(OrderException e) {
		String msg = e.getErrorMsg();
		HttpStatus status = e.getHttpStatus();
		return new ResponseEntity<>(new ErrorResponse(msg), status);
	}
}
