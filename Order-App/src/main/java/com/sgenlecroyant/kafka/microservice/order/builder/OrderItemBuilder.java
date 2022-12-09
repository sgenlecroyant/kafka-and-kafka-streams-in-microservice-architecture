package com.sgenlecroyant.kafka.microservice.order.builder;

import org.apache.commons.lang3.RandomStringUtils;

import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;

public class OrderItemBuilder {

	private String id;
	private String name;
	private Double price;
	private Integer quantity;
	private Order order;

	public OrderItemBuilder(OrderItem orderItem) {
		this.id = RandomStringUtils.randomAlphanumeric(10);
		this.name = orderItem.getName();
		this.price = orderItem.getPrice();
		this.quantity = orderItem.getQuantity();
		this.order = orderItem.getOrder();
	}

	public String getId() {
		return id;
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

	public OrderItemBuilder name(String name) {
		this.name = name;
		return this;
	}

	public OrderItemBuilder price(Double price) {
		this.price = price;
		return this;
	}

	public OrderItemBuilder withQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public OrderItem build() {
		return new OrderItem(this);
	}

}
