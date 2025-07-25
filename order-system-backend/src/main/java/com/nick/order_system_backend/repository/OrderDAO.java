package com.nick.order_system_backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nick.order_system_backend.entity.Order;
import com.nick.order_system_backend.entity.OrderItem;

public interface OrderDAO {

	//新增訂單、更新訂單
	Order saveOrder(Order order);
	//查看單筆訂單
	Order findById(long id);
	//查看單筆訂單+明細
	Order findByIdWithItems(long id);
	//查看分頁內的所有訂單
	Page<Order> findAll(Pageable pageable);
	//找特定的訂單明細
	OrderItem findOderItem(long orderId, long menuId);
	//確認訂單
	Order confirmOrder(long orderId);
	//取消訂單
	Order cancelOrder(long orderId);
	//刪除訂單明細
	void deleteOrderItem(OrderItem orderItem);
}
