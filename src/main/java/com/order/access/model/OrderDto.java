package com.order.access.model;

import com.order.constant.OrderStatus;

public class OrderDto {

	private Integer id;
	private Integer distance;
	private OrderStatus status;

	public OrderDto(Integer id, Integer distance, OrderStatus status) {
		this.id = id;
		this.distance = distance;
		this.status = status;
	}

	public OrderDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
