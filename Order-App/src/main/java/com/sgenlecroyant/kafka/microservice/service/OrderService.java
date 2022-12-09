package com.sgenlecroyant.kafka.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.kafka.microservice.action.OrderAction;
import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.entity.Order;

@Service
public class OrderService {

	private final OrderAction orderAction;

	@Autowired
	public OrderService(OrderAction orderAction) {
		this.orderAction = orderAction;
	}

	public Order saveAndSend(OrderRequest orderRequest) {
		Order order = this.orderAction.saveAndSend(orderRequest);
		return order;
	}

}
