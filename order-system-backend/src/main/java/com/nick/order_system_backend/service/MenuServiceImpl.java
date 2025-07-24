package com.nick.order_system_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.order_system_backend.entity.Menu;
import com.nick.order_system_backend.entity.OrderItem;
import com.nick.order_system_backend.repository.MenuDAO;
import com.nick.order_system_backend.repository.OrderDAO;

import jakarta.transaction.Transactional;

@Service
public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;
	private OrderDAO orderDAO;
	
	@Autowired
	public MenuServiceImpl(MenuDAO menuDAO, OrderDAO orderDAO) {
		this.menuDAO = menuDAO;
		this.orderDAO = orderDAO;
	}
	
	@Override
	public List<Menu> getMenu() {
		return menuDAO.findAll();
	}

	@Override
	@Transactional
	public Menu saveMenu(Menu menu) {
		return menuDAO.save(menu);
	}

	@Override
	@Transactional
	public void deleteByMenuId(long id) {
		//找到所有相關的訂單明細
		List<OrderItem> orderItems = menuDAO.findOrderItemsByMenuId(id);
		//刪除他們
		for(OrderItem orderItem:orderItems) {
			orderDAO.deleteOrderItem(orderItem);
		}
		//刪除菜單品項
		menuDAO.deleteById(id);
	}

	@Override
	public Menu findById(long id) {
		return menuDAO.findById(id);
	}

}
