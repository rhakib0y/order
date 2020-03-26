package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.order.constant.OrderStatus;
import com.order.entity.model.Order;
import com.order.exception.OrderException;
import com.order.google.api.DistanceApiClient;
import com.order.google.api.data.DistanceParams;
import com.order.repository.OrderRepository;

@Service
@Transactional(rollbackOn = { Exception.class })
public class OrderService {

	@Autowired
	OrderRepository repo;

	@Autowired
	DistanceApiClient distanceApi;

	public Order placeOrder(Order order) {
		DistanceParams params = new DistanceParams(order.getOrigin(), order.getDestination());
		Integer distance = distanceApi.get(params);
		order.setDistance(distance);
		order.setStatus(OrderStatus.UNASSIGNED);
		return repo.save(order);
	}

	public Order takeOrder(Integer id, OrderStatus status) {
		Order order = repo.getOne(id);
		if (OrderStatus.TAKEN == order.getStatus()) {
			throw new OrderException("This order is already taken.");
		} else {
			order.setStatus(status);
		}

		return repo.save(order);
	}

	public List<Order> getOrderList(Integer page, Integer limit) {
		Pageable pageable = PageRequest.of(page - 1, limit);
		Page<Order> pageResult = repo.findAll(pageable);
		List<Order> orders = new ArrayList<>();
		Optional.ofNullable(pageResult.getContent()).ifPresent(orders::addAll);
		return orders;

	}

}
