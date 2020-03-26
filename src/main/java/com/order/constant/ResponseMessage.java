package com.order.constant;

public enum ResponseMessage {

	SOMETHING_WENT_WRONG("Something went wrong"),
	RECORD_NOT_FOUND("Order not found.");

	private String value;

	ResponseMessage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
