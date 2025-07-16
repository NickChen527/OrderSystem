package com.nick.order_system_backend.repository;

import java.util.List;

import com.nick.order_system_backend.entity.OrderItem;

public interface OrderItemDAO {

	//加入購物車、修改購物車內容
	OrderItem save(OrderItem orderItem);
	//從購物車中移除
	void deleteById(long id);
	//透過訂單編號找訂單明細
	List<OrderItem> findByOrderId(long orderId);
	
}
