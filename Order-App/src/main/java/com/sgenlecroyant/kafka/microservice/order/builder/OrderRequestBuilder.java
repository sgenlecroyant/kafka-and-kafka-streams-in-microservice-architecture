package com.sgenlecroyant.kafka.microservice.order.builder;

import java.util.List;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;

public class OrderRequestBuilder {

	private String creditCardNumber;
	private String location;
	private List<OrderItem> items;

	public OrderRequestBuilder(OrderRequest orderRequest) {
		this.creditCardNumber = orderRequest.getCreditCardNumber();
		this.location = orderRequest.getLocation();
		this.items = orderRequest.getItems();
	}

	public OrderRequestBuilder location(String location) {
		this.location = location;
		return this;
	}

	public OrderRequestBuilder withCreditcardNumber(String creditcardNumber) {
		this.creditCardNumber = creditcardNumber;
		return this;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getLocation() {
		return location;
	}

}
