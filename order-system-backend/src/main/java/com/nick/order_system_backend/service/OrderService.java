package com.nick.order_system_backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nick.order_system_backend.dto.OrderListDTO;
import com.nick.order_system_backend.dto.RequestItemDTO;
import com.nick.order_system_backend.entity.Order;

public interface OrderService {

	//前台功能
	//新增訂單
	Order newOrder(List<RequestItemDTO> dtos);
	//依照分頁取得訂單
	Page<OrderListDTO> getOrders(Pageable pageable);
	//更新訂單狀態
	void changeStatus(Long orderId, String status);
	

}
