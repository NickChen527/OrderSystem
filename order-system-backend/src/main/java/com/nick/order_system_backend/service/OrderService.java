package com.nick.order_system_backend.service;

import com.nick.order_system_backend.entity.Order;

public interface OrderService {

	//前台功能
	//點餐
	Order order(long orderId,long menuId,int quantity);

}
