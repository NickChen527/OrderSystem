package com.nick.order_system_backend.dto;

import java.util.List;

public class ResponseDTO {

	private List<ResponseItemDTO> items; 
	private Double total;
	
	public List<ResponseItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ResponseItemDTO> items) {
		this.items = items;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}
