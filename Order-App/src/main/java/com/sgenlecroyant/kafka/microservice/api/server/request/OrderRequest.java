package com.sgenlecroyant.kafka.microservice.api.server.request;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;
import com.sgenlecroyant.kafka.microservice.order.builder.OrderRequestBuilder;

public class OrderRequest {
	private String location;
	private String creditCardNumber;
	private List<OrderItem> items;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public static OrderRequestBuilder newBuilder(OrderRequest orderRequest) {
		return new OrderRequestBuilder(orderRequest);
	}

	public static Order createOrderFromRequest(OrderRequest orderRequest) {

		Order order = new Order();
		order.setId(RandomStringUtils.randomAlphanumeric(10));
		order.setLocation(orderRequest.getLocation());
		order.setItems(orderRequest.getItems());
		order.setCreditCardNumber(orderRequest.getCreditCardNumber());

		return order;
	}

}
