package com.sgenlecroyant.kafka.microservice.entity;

import com.sgenlecroyant.kafka.microservice.order.builder.OrderItemBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "order-items")
@Table(name = "order-items")
public class OrderItem {

	@Id
	private String id;
	private String name;
	private Double price;
	private Integer quantity;

	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {

	}

	public OrderItem(OrderItemBuilder builder) {
		this.id = builder.getId();
		this.name = builder.getName();
		this.price = builder.getPrice();
		this.quantity = builder.getQuantity();
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

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public static OrderItemBuilder newBuilder(OrderItem orderItem) {
		return new OrderItemBuilder(orderItem);
	}

}
