package com.sgenlecroyant.kafka.microservice.order.builder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;
import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;

public class OrderMessageBuilder {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String orderId;
	private String creditCardNumber;
	private String location;

	private String name;
	private Double price;
	private Integer quantity;
	private String itemId;

	public OrderMessageBuilder(OrderItem orderItem, Order order) {
		this.orderId = order.getId();
		this.creditCardNumber = order.getCreditCardNumber();
		this.location = order.getLocation();

		this.name = orderItem.getName();
		this.itemId = orderItem.getId();
		this.price = orderItem.getPrice();
		this.quantity = orderItem.getQuantity();
	}

	public String getOrderId() {
		return orderId;
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

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getLocation() {
		return location;
	}

	public String getItemId() {
		return itemId;
	}

	public OrderMessage build() {
		return new OrderMessage(this);
	}

}
