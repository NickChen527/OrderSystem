package com.nick.order_system_backend.repository;

import java.util.List;

import com.nick.order_system_backend.entity.OrderItem;

public interface OrderItemDAO {

	//加入購物車
	OrderItem save(OrderItem orderItem);
	//查看餐點
	List<OrderItem> findAll();
	
}
