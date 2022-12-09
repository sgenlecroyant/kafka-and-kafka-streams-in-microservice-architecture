package com.sgenlecroyant.kafka.microservice.api.server.response;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;

public class OrderResponse {

	private String orderNumber;

	private OrderResponse(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}
	
	public static OrderResponse createOrderResponse(OrderMessage orderMessage) {
		return new OrderResponse(orderMessage.getId());
	}

}
