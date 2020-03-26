package com.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.access.mapper.OrderMapper;
import com.order.access.mapper.PlaceOrderMapper;
import com.order.access.model.OrderDto;
import com.order.access.model.PlaceOrder;
import com.order.access.model.TakeOrderDto;
import com.order.constant.OrderStatus;
import com.order.entity.model.Order;
import com.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService service;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private PlaceOrderMapper placeMapper;

	@PostMapping()
	public ResponseEntity<OrderDto> placeOrder(@RequestBody @Valid PlaceOrder placeOrder) {
		Order order = placeMapper.mapEntity(placeOrder);
		Order result = service.placeOrder(order);
		OrderDto reponse = orderMapper.mapDto(result);
		return ResponseEntity.ok(reponse);
	}

	@GetMapping()
	public ResponseEntity<List<OrderDto>> orderList(@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer limit) {
		List<Order> orders = service.getOrderList(page, limit);
		return ResponseEntity.ok(orderMapper.mapDtoList(orders));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<TakeOrderDto> takeOrder(@PathVariable(name = "id") Integer id,
			@RequestBody @Valid TakeOrderDto dto) {
		service.takeOrder(id, dto.getStatus());
		return ResponseEntity.ok(new TakeOrderDto(OrderStatus.SUCCESS));
	}

}
