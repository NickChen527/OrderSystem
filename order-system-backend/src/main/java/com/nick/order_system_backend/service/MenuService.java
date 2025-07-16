package com.nick.order_system_backend.service;

import java.util.List;

import com.nick.order_system_backend.entity.Menu;

public interface MenuService {

	//顯示所有餐點
	List<Menu> getMenu();
	//新增餐點、修改餐點
	Menu saveMenu(Menu menu);
	//刪除餐點
	void deleteByMenuId(long id);
}
