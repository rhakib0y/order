package com.order.access.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.order.constant.OrderStatus;

public class TakeOrderDto {

	@Valid
	@NotNull
	private OrderStatus status;

	public TakeOrderDto(@Valid @NotNull OrderStatus status) {
		this.status = status;
	}

	public TakeOrderDto() {
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
