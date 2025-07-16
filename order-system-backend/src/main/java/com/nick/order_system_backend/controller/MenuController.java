package com.nick.order_system_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nick.order_system_backend.entity.Menu;
import com.nick.order_system_backend.service.MenuService;

@RestController
@RequestMapping("/api")
public class MenuController {

	private MenuService menuService;
	//因為要做 PATCH 所以多一個 ObjectMapper
	private ObjectMapper objectMapper;
	
	@Autowired
	public MenuController(MenuService menuService, ObjectMapper objectMapper) {
		this.menuService = menuService;
		this.objectMapper = objectMapper;
	}
	
	//顯示全部菜單
	@GetMapping("/menus")
	public List<Menu> getMenu(){
		return menuService.getMenu();
	}
	
	//新增菜單(不要有id)
	@PostMapping("/menus")
	public Menu newMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}
	
	//透過 id 修改菜單 (用PATCH，所以要多寫一個apply方法)
	@PatchMapping("/menus/{menuId}")
	public Menu updateMenu(@PathVariable long menuId, @RequestBody Map<String, Object> payload) {
		Menu menu = menuService.findById(menuId);
		return menuService.saveMenu(apply(payload, menu));
	}
	//這個專門給PATCH用的
	private Menu apply(Map<String, Object> payload,Menu menu) {
		ObjectNode menuNode = objectMapper.convertValue(menu, ObjectNode.class);
		ObjectNode payloadNode = objectMapper.convertValue(payload, ObjectNode.class);
		menuNode.setAll(payloadNode);
		return objectMapper.convertValue(menuNode, Menu.class);
	}
	
	//透過 id 刪除菜單
	@DeleteMapping("/menus/{menuId}")
	public void deleteMenu(@PathVariable long menuId) {
		menuService.deleteByMenuId(menuId);
	}
	
	
	
	
	
	
	
	
	
}
