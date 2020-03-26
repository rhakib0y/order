package com.order.exception;

import org.springframework.http.HttpStatus;

public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMsg;
	private HttpStatus httpStatus;

	public OrderException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.httpStatus = HttpStatus.CONFLICT;
	}

	public OrderException(String errorMsg, HttpStatus httpStatus) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	
}
