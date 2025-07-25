package com.nick.order_system_backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.nick.order_system_backend.entity.Order;
import com.nick.order_system_backend.entity.OrderItem;
import com.nick.order_system_backend.type.OrderStatus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class OrderDAOImpl implements OrderDAO{

	private EntityManager entityManager;
	
	@Autowired
	public OrderDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Order findById(long id) {
		return entityManager.find(Order.class, id);
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		String hql = "SELECT o FROM Order o";
		TypedQuery<Order> query = entityManager.createQuery(hql, Order.class);
		//設定第一筆從哪裡開始
		query.setFirstResult((int)pageable.getOffset());
		//設定總共要查幾筆
		query.setMaxResults(pageable.getPageSize());
		List<Order> orders = query.getResultList();
		//因為要支援Page的回傳型別，所以需要總共幾筆的資料
	    String countHql = "SELECT COUNT(o) FROM Order o";
	    Long count = entityManager.createQuery(countHql, Long.class).getSingleResult();

	    return new PageImpl<>(orders, pageable, count);
	}

	@Override
	public Order saveOrder(Order order) {
		return entityManager.merge(order);
	}

	@Override
	public Order findByIdWithItems(long id) {
		String hql = "SELECT o FROM Order o JOIN FETCH o.orderItems JOIN FETCH o.orderItems.menu WHERE o.id=:data";
		TypedQuery<Order> query = entityManager.createQuery(hql,Order.class);
		query.setParameter("data", id);
		return query.getSingleResult();
	}

	@Override
	public OrderItem findOderItem(long orderId, long menuId) {
		String hql = "SELECT o FROM OrderItem o JOIN FETCH o.order JOIN FETCH o.menu WHERE o.order.id=:orderId AND o.menu.id=:menuId";
		TypedQuery<OrderItem> query = entityManager.createQuery(hql, OrderItem.class);
		query.setParameter("orderId", orderId);
		query.setParameter("menuId", menuId);
		return query.getSingleResult();
	}

	@Override
	public Order confirmOrder(long orderId) {
		Order order = entityManager.find(Order.class, orderId);
		order.setOrderStatus(OrderStatus.CONFIRMED);
		return entityManager.merge(order);
	}

	@Override
	public Order cancelOrder(long orderId) {
		Order order = entityManager.find(Order.class, orderId);
		order.setOrderStatus(OrderStatus.CANCELLED);
		return entityManager.merge(order);
	}

	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		entityManager.remove(orderItem);
	}

}
