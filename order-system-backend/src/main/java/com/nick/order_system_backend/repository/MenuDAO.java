package com.nick.order_system_backend.repository;

import java.util.List;

import com.nick.order_system_backend.entity.Menu;
import com.nick.order_system_backend.entity.OrderItem;

public interface MenuDAO {

	//儲存餐點
	Menu save(Menu menu);
	
	//刪除餐點
	void deleteById(long id);

	//查詢全部餐點
	List<Menu> findAll();
	
	//查詢單筆餐點
	Menu findById(long id);
	
	//透過餐點ID找訂單明細
	List<OrderItem> findOrderItemsByMenuId(long id);
}
