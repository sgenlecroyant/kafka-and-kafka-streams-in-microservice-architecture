package com.sgenlecroyant.kafka.microservice.api.server.request;

import com.sgenlecroyant.kafka.microservice.entity.Order;

public class OrderItemRequest {

	private String name;
	private Double price;
	private Integer quantity;
	private Order order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

}
