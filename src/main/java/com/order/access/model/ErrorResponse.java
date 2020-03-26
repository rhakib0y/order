package com.order.access.model;

import com.order.constant.ResponseMessage;

public class ErrorResponse {

	private String error;

	public ErrorResponse() {
	}

	public ErrorResponse(String error) {
		this.error = error;
	}
	
	public ErrorResponse(ResponseMessage error) {
		this.error = error.getValue();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
