package com.nick.order_system_backend.dto;

import java.util.List;

public class RequestDTO {

	private List<RequestItemDTO> items;

	public List<RequestItemDTO> getItems() {
		return items;
	}

	public void setItems(List<RequestItemDTO> items) {
		this.items = items;
	}
	
}
