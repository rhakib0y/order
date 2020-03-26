package com.order.access.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.order.access.model.PlaceOrder;
import com.order.entity.model.Order;
import com.order.exception.InvalidDataFormatException;

@Component
public class PlaceOrderMapper implements BaseMapper<Order, PlaceOrder> {

	private static final String FLOAT_TEXT = "[-+]?[0-9]*\\.?[0-9]+";
	private final Pattern pattern = Pattern.compile(FLOAT_TEXT);

	@Override
	public boolean isEntityValid(Order entity) {
		return false;
	}

	@Override
	public boolean isDtoValid(PlaceOrder dto) {
		List<String> coordinates = new ArrayList<>();
		boolean isValid = true;
		Matcher matcher;
		coordinates.addAll(dto.getOrigin());
		coordinates.addAll(dto.getDestination());
		for (String input : coordinates) {
			matcher = pattern.matcher(input);
			if (!matcher.matches()) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	@Override
	public Order mapEntity(PlaceOrder dto) {
		Order order = new Order();
		if (!isDtoValid(dto)) {
			throw new InvalidDataFormatException("Invalid latitude / longitude format");
		}
		order.setOrigin(dto.getOrigin().stream().collect(Collectors.joining(",")));
		order.setDestination(dto.getDestination().stream().collect(Collectors.joining(",")));
		return order;
	}

	@Override
	public PlaceOrder mapDto(Order entity) {
		return null;
	}

}
