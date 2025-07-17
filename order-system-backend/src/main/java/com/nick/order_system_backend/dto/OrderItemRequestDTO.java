package com.nick.order_system_backend.dto;

public class OrderItemRequestDTO {

	private Long orderId;
	private Long menuId;
	private Integer quantity;
	
	public OrderItemRequestDTO() {}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
