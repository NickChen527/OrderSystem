package com.nick.order_system_backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nick.order_system_backend.entity.Order;

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
	public List<Order> findAll() {
		String hql = "SELECT o FROM Order o";
		TypedQuery<Order> query = entityManager.createQuery(hql, Order.class);
		return query.getResultList();
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

}
