package com.nick.order_system_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nick.order_system_backend.dto.RequestDTO;
import com.nick.order_system_backend.dto.ResponseDTO;
import com.nick.order_system_backend.dto.ResponseItemDTO;
import com.nick.order_system_backend.entity.Order;
import com.nick.order_system_backend.entity.OrderItem;
import com.nick.order_system_backend.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//新增訂單
	@PostMapping("/orders")
	public ResponseDTO newOrder(@RequestBody RequestDTO dtos) {
		//呼叫Service方法、接收回傳的訂單資料
		Order order = orderService.newOrder(dtos.getItems());
		//包裝前端需要的資料
		ResponseDTO response = new ResponseDTO();
		List<ResponseItemDTO> temp = new ArrayList<ResponseItemDTO>();
		for(OrderItem orderitem:order.getOrderItems()) {
			ResponseItemDTO responseItem = new ResponseItemDTO();
			responseItem.setMenuName(orderitem.getMenu().getName());
			responseItem.setPrice(orderitem.getMenu().getPrice());
			responseItem.setQuantity(orderitem.getQuantity());
			temp.add(responseItem);
		}
		response.setItems(temp);
		response.setTotal(order.getTotalAmount());
		//回傳
		return response;
	}
}
