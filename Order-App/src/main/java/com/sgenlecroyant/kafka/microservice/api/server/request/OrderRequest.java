package com.sgenlecroyant.kafka.microservice.api.server.request;

import com.sgenlecroyant.kafka.microservice.order.builder.OrderRequestBuilder;

public class OrderRequest {

	private String name;
	private Double price;
	private Integer quantity;

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public static OrderRequestBuilder newBuilder(OrderRequest orderRequest) {
		return new OrderRequestBuilder(orderRequest);
	}

}
