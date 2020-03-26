package com.order.google.api.data;

public class DistanceParams {

	private String origin;
	private String destination;

	public DistanceParams() {
	}

	public DistanceParams(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
