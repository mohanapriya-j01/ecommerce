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

@Service
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
		ProductsOrdered productsOrdered = new ProductsOrdered();
		productsOrdered.setBuyerId(orderDTO.getBuyerId());
		productsOrdered.setProdId(null);
		productsOrdered.setQuantity(null);
		productsOrdered.setSellerId(null);
		productsOrderedRepository.save(productsOrdered);
		return "Order placed Successfully";
	}

    public String reOrder(Integer buyerId, Integer prodId) {
    	ProductsOrdered productsOrdered = productsOrderedRepository.findByBuyerIdAndProdId(buyerId, prodId);
    	OrderDTO dto = orderRepository.findByBuyerId(buyerId);
    	Order order = new Order();
    	order.setAddress(dto.getAddress());
		order.setBuyerId(dto.getBuyerId());
		order.setAmount(null);
		LocalDate date = LocalDate.now();
		order.setDate(date);
		order.setStatus("Order Placed");
		orderRepository.save(order);
		productsOrderedRepository.save(productsOrdered);
		return "ReOrder is Successful";
    }
    
    public OrderDTO viewOrder(Integer orderId) {
    	Order order = orderRepository.findById(orderId).get();
    	OrderDTO dto = new OrderDTO();
    	dto.setOrderId(order.getOrderId());
    	dto.setBuyerId(order.getBuyerId());
    	dto.setAmount(order.getAmount());
    	dto.setDate(order.getDate());
    	dto.setAddress(order.getAddress());
    	dto.setStatus(order.getStatus());
    	dto.setOrderedProducts(null);
    	return dto;
    }
}
