package com.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Page<Order> findAll(Pageable pageable);

}
