package com.nick.order_system_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Order order(long orderId, long menuId, int quantity) {
		Order order = orderDAO.findById(orderId);
		if(order==null) {
			Order newOrder = new Order();
			//找餐點資訊
			Menu menu = menuDAO.findById(menuId);
			//找這個餐點多少錢
			Double menuPrice = menu.getPrice();
			//算這筆明細的金額
			Double itemPrice = menuPrice*quantity;
			//把資料塞到明細裡
			OrderItem orderItem = new OrderItem();
			orderItem.setMenu(menu);
			orderItem.setItemPrice(itemPrice);
			orderItem.setQuantity(quantity);
			//把訂單明細加入訂單裡面
			newOrder.addOrderItem(orderItem);
			//計算總金額
			Double totalAmout = newOrder.getTotalAmount()+orderItem.getItemPrice();
			newOrder.setTotalAmount(totalAmout);
			orderDAO.saveOrder(newOrder);
			return orderDAO.findByIdWithItems(newOrder.getId());
		} else {
			//找餐點資訊
			Menu menu = menuDAO.findById(menuId);
			//找這個餐點多少錢
			Double menuPrice = menu.getPrice();
			//算這筆明細的金額
			Double itemPrice = menuPrice*quantity;
			//把資料塞到明細裡
			OrderItem orderItem = new OrderItem();
			orderItem.setMenu(menu);
			orderItem.setItemPrice(itemPrice);
			orderItem.setQuantity(quantity);
			//把訂單明細加入訂單裡面
			order.addOrderItem(orderItem);
			//計算總金額
			Double totalAmount = order.getTotalAmount()+orderItem.getItemPrice();
			order.setTotalAmount(totalAmount);
			orderDAO.saveOrder(order);
			return orderDAO.findByIdWithItems(order.getId());
		}
	}
}
