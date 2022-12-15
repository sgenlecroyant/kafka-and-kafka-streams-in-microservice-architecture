package com.sgenlecroyant.kafka.microservice.api.server.response;

import com.sgenlecroyant.kafka.microservice.entity.Order;

public class OrderResponse {

	private String orderNumber;

	private OrderResponse(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public static OrderResponse createOrderResponse(Order order) {
		return new OrderResponse(order.getId());
	}

}
