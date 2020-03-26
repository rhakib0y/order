package com.order.exception;

import org.springframework.http.HttpStatus;

public class InvalidDataFormatException extends RuntimeException {

	private static final long serialVersionUID = -8934891034450571883L;
	private String errorMsg;
	private HttpStatus httpStatus;

	public InvalidDataFormatException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}

	public InvalidDataFormatException(String errorMsg, HttpStatus httpStatus) {
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
