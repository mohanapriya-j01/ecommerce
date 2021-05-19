package com.infosys.order.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.order.dto.OrderDTO;
import com.infosys.order.entity.Order;
import com.infosys.order.entity.ProductsOrdered;
import com.infosys.order.repository.OrderRepository;
import com.infosys.order.repository.ProductsOrderedRepository;

@Service(value="serviceRepository")
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductsOrderedRepository productsOrderedRepository;
	
	public String placeOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setAddress(orderDTO.getAddress());
		order.setBuyerId(orderDTO.getBuyerId());
		order.setStatus("Order Placed");
		order.setAmount(null);
		LocalDate date = LocalDate.now();
		order.setDate(date);
		orderRepository.save(order);
		return "Order placed Successfully";
	}

    public String reOrder(Integer buyerId, Integer prodId) {
    	return "ReOrder is Successful";
//    	ProductsOrdered productsOrdered = productsOrderedRepository.findByBuyerIdAndProdId(buyerId, prodId);
//    	OrderDTO dto = orderRepository.findByBuyerId(buyerId);
//    	Order order = new Order();
//    	order.setAddress(dto.getAddress());
//		order.setBuyerId(dto.getBuyerId());
//		order.setAmount(null);
//		LocalDate date = LocalDate.now();
//		order.setDate(date);
//		order.setStatus("Order Placed");
//		orderRepository.save(order);
//		productsOrderedRepository.save(productsOrdered);
//		return "ReOrder is Successful";
    }
    
    public OrderDTO viewOrder(Integer orderId) {
    	Order order = orderRepository.findById(orderId).get();
    	OrderDTO dto = new OrderDTO();
    	dto.setBuyerId(order.getBuyerId());
    	dto.setAddress(order.getAddress());
    	return dto;
    }
}
