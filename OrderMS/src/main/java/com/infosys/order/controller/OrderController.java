package com.infosys.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.order.dto.OrderDTO;
import com.infosys.order.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderService orderService;
	
	// Place an order 
	@PostMapping(value = "/orders/placeOrder",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) {
       String msg = orderService.placeOrder(orderDTO);
	   return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	// Reorder 
	@PostMapping(value = "/orders/reOrder/{buyerId}/{prodId}")
	public ResponseEntity<String> reOrder(@PathVariable  Integer buyerId, @PathVariable Integer prodId) {
		String msg = orderService.reOrder(buyerId, prodId);
		return new ResponseEntity<>(msg,HttpStatus.OK);	
	}


	// Fetches order based on orderId
	@GetMapping(value = "/orders/{orderId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDTO> viewOrder(@PathVariable Integer orderId) {
		OrderDTO dto = orderService.viewOrder(orderId);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}



}
