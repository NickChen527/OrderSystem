package com.nick.order_system_backend.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nick.order_system_backend.type.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	//Fields
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_time")
	private LocalDateTime orderTime = LocalDateTime.now();
	
	@Column(name = "total_amount")
	private Double totalAmount = 0.0;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus = OrderStatus.DRAFT;

	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference
	private List<OrderItem> orderItems;

	//Constructors
	public Order() {}
	

	public Order(LocalDateTime orderTime, Double totalAmount) {
		super();
		this.orderTime = orderTime;
		this.totalAmount = totalAmount;
	}

	//Getters、Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		if(orderItems==null) {
			orderItems = new ArrayList<OrderItem>();
		}
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", totalAmount=" + totalAmount + ", orderStatus="
				+ orderStatus + "]";
	}
	
}
