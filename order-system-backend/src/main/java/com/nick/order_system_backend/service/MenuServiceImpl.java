package com.nick.order_system_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.order_system_backend.entity.Menu;
import com.nick.order_system_backend.repository.MenuDAO;

@Service
public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;
	
	@Autowired
	public MenuServiceImpl(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
	@Override
	public List<Menu> getMenu() {
		return menuDAO.findAll();
	}

	@Override
	public Menu saveMenu(Menu menu) {
		return menuDAO.save(menu);
	}

	@Override
	public void deleteByMenuId(long id) {
		menuDAO.deleteById(id);
	}

}
