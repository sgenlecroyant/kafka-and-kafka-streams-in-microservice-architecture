package com.sgenlecroyant.kafka.microservice.order.builder;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;

public class OrderRequestBuilder {

	private String name;
	private Double price;
	private Integer quantity;

	public OrderRequestBuilder(OrderRequest orderRequest) {
		this.name = orderRequest.getName();
		this.price = orderRequest.getPrice();
		this.quantity = orderRequest.getQuantity();
	}

	public OrderRequestBuilder name(String name) {
		this.name = name;
		return this;
	}

	public OrderRequestBuilder price(Double price) {
		this.price = price;
		return this;
	}

	public OrderRequestBuilder withQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderMessage build() {

		return new OrderMessage(this);
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

}
