package com.sgenlecroyant.kafka.microservice.service;

import org.springframework.stereotype.Service;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.producer.OrderProducer;

@Service
public class OrderService {

	private final OrderProducer orderProducer;

	public OrderService(OrderProducer orderProducer) {
		this.orderProducer = orderProducer;
	}

	public OrderMessage sendOrderToKafka(OrderRequest orderRequest) {
		OrderMessage orderMessage = OrderRequest.newBuilder(orderRequest).build();
		this.orderProducer.sendToKafka(orderMessage);
		return orderMessage;

	}

}
