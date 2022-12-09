package com.sgenlecroyant.kafka.microservice.broker.order.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;
import com.sgenlecroyant.kafka.microservice.order.builder.OrderMessageBuilder;

public class OrderMessage {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String orderId;
	private String name;
	private Double price;
	private Integer quantity;
	private String creditCardNumber;
	private String location;
	private String itemId;

	public OrderMessage(String orderId, String name, Double price, Integer quantity, String creditCardNumber,
			String location, String itemId) {
		this.orderId = orderId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.creditCardNumber = creditCardNumber;
		this.location = location;
		this.itemId = itemId;
		this.logger.info("{}", this);
	}

	public OrderMessage(OrderMessageBuilder orderMessageBuilder) {
		this.orderId = orderMessageBuilder.getOrderId();
		this.name = orderMessageBuilder.getName();
		this.price = orderMessageBuilder.getPrice();
		this.quantity = orderMessageBuilder.getQuantity();
		this.creditCardNumber = orderMessageBuilder.getCreditCardNumber();
		this.location = orderMessageBuilder.getLocation();
		this.itemId = orderMessageBuilder.getItemId();
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

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public static OrderMessageBuilder newBuilder(OrderItem orderItem, Order order) {
		return new OrderMessageBuilder(orderItem, order);
	}

	@Override
	public String toString() {
		return "OrderMessage [orderId=" + orderId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", creditCardNumber=" + creditCardNumber + ", location=" + location + ", itemId=" + itemId + "]";
	}

}
