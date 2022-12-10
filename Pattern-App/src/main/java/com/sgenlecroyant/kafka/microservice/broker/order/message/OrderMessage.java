package com.sgenlecroyant.kafka.microservice.broker.order.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderMessage {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String orderId;
	private String name;
	private Double price;
	private Integer quantity;
	private String creditCardNumber;
	private String location;
	private String itemId;

	public OrderMessage() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "OrderMessage [orderId=" + orderId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", creditCardNumber=" + creditCardNumber + ", location=" + location + ", itemId=" + itemId + "]";
	}

}
