package com.order.access.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PlaceOrder {

	@Valid
	@Size(min = 2, max = 2)
	private List<@Valid @NotNull @NotEmpty String> origin;
	@Valid
	@Size(min = 2, max = 2)
	private List<@Valid @NotNull @NotEmpty String> destination;

	public List<String> getOrigin() {
		return origin;
	}

	public void setOrigin(List<String> origin) {
		this.origin = origin;
	}

	public List<String> getDestination() {
		return destination;
	}

	public void setDestination(List<String> destination) {
		this.destination = destination;
	}

}
