package com.nick.order_system_backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nick.order_system_backend.entity.Menu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class MenuDAOImpl implements MenuDAO{

	private EntityManager entityManager;
	
	@Autowired
	public MenuDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Menu save(Menu menu) {
		return entityManager.merge(menu);
	}

	@Override
	public void deleteById(long id) {
		Menu menu = entityManager.find(Menu.class, id);
		entityManager.remove(menu);
	}

	@Override
	public List<Menu> findAll() {
		String hql = "SELECT m FROM Menu m";
		TypedQuery<Menu> query = entityManager.createQuery(hql, Menu.class);
		return query.getResultList();
	}

	@Override
	public Menu findById(long id) {
		return entityManager.find(Menu.class, id);
	}

}
