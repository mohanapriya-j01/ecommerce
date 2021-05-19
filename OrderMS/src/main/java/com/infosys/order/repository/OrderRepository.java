package com.infosys.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.order.dto.OrderDTO;
import com.infosys.order.entity.Order;

@Repository(value="orderRepository")
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public OrderDTO findByBuyerId(Integer buyerId);
	
}
