package com.nick.order_system_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.order_system_backend.entity.Order;
import com.nick.order_system_backend.entity.OrderItem;
import com.nick.order_system_backend.repository.OrderDAO;
import com.nick.order_system_backend.repository.OrderItemDAO;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	private OrderItemDAO orderItemDAO;
	
	@Autowired
	public OrderServiceImpl(OrderDAO orderDAO, OrderItemDAO orderItemDAO) {
		this.orderDAO = orderDAO;
		this.orderItemDAO = orderItemDAO;
	}
	
	@Override
	@Transactional
	public Order save(Order order) {
		return orderDAO.save(order);
	}

	@Override
	@Transactional
	public OrderItem save(OrderItem orderItem) {
		return orderItemDAO.save(orderItem);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		orderItemDAO.deleteById(id);
	}

	@Override
	public List<OrderItem> findOrderItemsByOrderId(long orderId) {
		return orderItemDAO.findByOrderId(orderId);
	}

	@Override
	public List<Order> findAllOrder() {
		return orderDAO.findAll();
	}

}
