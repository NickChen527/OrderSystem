package com.nick.order_system_backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nick.order_system_backend.entity.OrderItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class OrderItemDAOImpl implements OrderItemDAO{

	private EntityManager entityManager;
	
	@Autowired
	public OrderItemDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public OrderItem save(OrderItem orderItem) {
		return entityManager.merge(orderItem);
	}

	@Override
	public List<OrderItem> findByOrderId(long orderId) {
		String hql = "SELECT o FROM OrderItem o WHERE o.orderId = :orderId";
		TypedQuery<OrderItem> query = entityManager.createQuery(hql, OrderItem.class);
		query.setParameter("orderId", orderId);
		return query.getResultList();
	}

	@Override
	public void deleteById(long id) {
		OrderItem orderItem = entityManager.find(OrderItem.class, id);
		entityManager.remove(orderItem);
	}

	

}
