package com.nick.order_system_backend.service;

import java.util.List;

import com.nick.order_system_backend.entity.Order;
import com.nick.order_system_backend.entity.OrderItem;

public interface OrderService {

	//前台功能
	//新增訂單
	Order save(Order order);
	//加入購物車、修改購物車內容
	OrderItem save(OrderItem orderItem);
	//從購物車中移除
	void deleteById(long id);
	
	//後臺功能
	//透過訂單編號找訂單明細
	List<OrderItem> findOrderItemsByOrderId(long orderId);
	//查看所有訂單
	List<Order> findAllOrder();
	
	
	
	
	
}
