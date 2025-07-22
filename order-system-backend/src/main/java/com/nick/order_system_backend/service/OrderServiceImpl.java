package com.nick.order_system_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.order_system_backend.dto.RequestItemDTO;
import com.nick.order_system_backend.entity.Menu;
import com.nick.order_system_backend.entity.Order;
import com.nick.order_system_backend.entity.OrderItem;
import com.nick.order_system_backend.repository.MenuDAO;
import com.nick.order_system_backend.repository.OrderDAO;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	private MenuDAO menuDAO;
	
	@Autowired
	public OrderServiceImpl(OrderDAO orderDAO,MenuDAO menuDAO) {
		this.orderDAO = orderDAO;
		this.menuDAO = menuDAO;
	}

	@Override
	@Transactional
	public Order newOrder(List<RequestItemDTO> dtos) {
		Double totalAmount = 0.0;
		//建立訂單
		Order order = new Order();
		for(RequestItemDTO dto : dtos) {
			//透過menuId找到對應餐點
			Menu menu = menuDAO.findById(dto.getMenuId());
			//建立並設定OrderItem
			OrderItem orderItem = new OrderItem();
			orderItem.setMenu(menu);
			orderItem.setItemPrice(menu.getPrice());
			orderItem.setQuantity(dto.getQuantity());
			//把OrderItem加入訂單中
			order.addOrderItem(orderItem);
			//累加總金額
			totalAmount += ( orderItem.getItemPrice()*orderItem.getQuantity() );
		}
		//設定訂單的total amount
		order.setTotalAmount(totalAmount);
		//更新訂單狀態
		Order result = orderDAO.saveOrder(order);
		//回傳訂單明細
		return orderDAO.findByIdWithItems(result.getId());
	}
}
