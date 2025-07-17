package com.nick.order_system_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nick.order_system_backend.dto.OrderItemRequestDTO;
import com.nick.order_system_backend.entity.Order;
import com.nick.order_system_backend.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/orders")
	public Order order(@RequestBody OrderItemRequestDTO dto) {
		return orderService.order(dto.getOrderId(), dto.getMenuId(), dto.getQuantity());
	}
	
	
}
