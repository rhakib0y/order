package com.order.access.mapper;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.order.access.model.OrderDto;
import com.order.entity.model.Order;

@Component
public class OrderMapper implements BaseMapper<Order, OrderDto> {

	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean isEntityValid(Order entity) {
		return true;
	}

	@Override
	public boolean isDtoValid(OrderDto dto) {
		return true;
	}

	@Override
	public Order mapEntity(OrderDto dto) {
		return modelMapper.map(dto, Order.class);
	}

	@Override
	public OrderDto mapDto(Order entity) {
		return modelMapper.map(entity, OrderDto.class);
	}

	@Override
	public List<Order> mapEntityList(List<OrderDto> dtoList) {
		if (dtoList == null) {
			return Collections.emptyList();
		}

		final List<Order> list = Lists.newArrayList();
		for (final OrderDto dto : dtoList) {
			final Order converted = mapEntity(dto);
			if (converted != null) {
				list.add(converted);
			}
		}
		return list;
	}

	@Override
	public List<OrderDto> mapDtoList(List<Order> entityList) {
		if (entityList == null) {
			return Collections.emptyList();
		}

		final List<OrderDto> list = Lists.newArrayList();
		for (final Order entity : entityList) {
			final OrderDto converted = mapDto(entity);
			if (converted != null) {
				list.add(converted);
			}
		}
		return list;
	}

}
