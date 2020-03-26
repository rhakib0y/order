package com.order.constant;

public enum OrderStatus {

	SUCCESS("SUCCESS"), TAKEN("TAKEN"), UNASSIGNED("UNASSIGNED");

	private String value;

	OrderStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
