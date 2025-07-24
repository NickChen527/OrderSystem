package com.nick.order_system_backend.service;

import java.util.List;

import com.nick.order_system_backend.dto.OrderListDTO;
import com.nick.order_system_backend.dto.RequestItemDTO;
import com.nick.order_system_backend.entity.Order;

public interface OrderService {

	//前台功能
	//新增訂單
	Order newOrder(List<RequestItemDTO> dtos);
	//取得所有訂單
	List<OrderListDTO> getOrders();
	//更新訂單狀態
	void changeStatus(Long orderId, String status);
	

}
