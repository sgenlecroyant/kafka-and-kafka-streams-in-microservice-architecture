package com.sgenlecroyant.kafka.microservice.broker.order.message;

import java.util.UUID;

import com.sgenlecroyant.kafka.microservice.order.builder.OrderRequestBuilder;

public class OrderMessage {

	private String id;
	private String name;
	private Double price;
	private Integer quantity;

	public OrderMessage(OrderRequestBuilder orderRequestBuilder) {
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
		this.name = orderRequestBuilder.getName();
		this.price = orderRequestBuilder.getPrice();
		this.quantity = orderRequestBuilder.getQuantity();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "OrderMessage [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
