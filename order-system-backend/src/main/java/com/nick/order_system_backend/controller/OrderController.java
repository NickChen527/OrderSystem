package com.nick.order_system_backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nick.order_system_backend.dto.OrderListDTO;
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
	
	//取得所有訂單
	@GetMapping("/orders")
	public Page<OrderListDTO> getOrdersByPage(@RequestParam int page,@RequestParam int size){
		Pageable pageable = PageRequest.of(page, size, Sort.by("orderTime").ascending());
		return orderService.getOrders(pageable);
	}
	
	//更新訂單狀態
	@PatchMapping("/orders")
	public String changeOrderStatus(@RequestBody Map<String, Object> data) {
		//因為JSON的數字預設轉換成Integer，不能直接換成Long，所以先變Number再變Long
		Number orderIdNumber = (Number) data.get("orderId");
		Long orderId = orderIdNumber.longValue();
		String status = (String) data.get("status");
		System.out.println(orderId);
		System.out.println(status);
		orderService.changeStatus(orderId, status);
		return"{\"status\":\"done\"}";
	}
	
}
