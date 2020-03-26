package com.order.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.order.constant.OrderStatus;

@Entity
@Table(name = "place_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "distance")
	private Integer distance;

	@NotNull
	@Column(name = "status")
	private OrderStatus status;

	@Column(name = "origin")
	private String origin;

	@Column(name = "destination")
	private String destination;

	public Order(Integer id, Integer distance, @NotNull OrderStatus status, String origin, String destination) {
		this.id = id;
		this.distance = distance;
		this.status = status;
		this.origin = origin;
		this.destination = destination;
	}

	public Order() {
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
