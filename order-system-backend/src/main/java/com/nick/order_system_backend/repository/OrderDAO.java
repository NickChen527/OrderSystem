package com.nick.order_system_backend.repository;

import java.util.List;

import com.nick.order_system_backend.entity.Order;

public interface OrderDAO {

	//新增訂單
	Order save(Order order);
	//查看單筆訂單
	Order findById(long id);
	//查看所有訂單
	List<Order> findAll();
}
