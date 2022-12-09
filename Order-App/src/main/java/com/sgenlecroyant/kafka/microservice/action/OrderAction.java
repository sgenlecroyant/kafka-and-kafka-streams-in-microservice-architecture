package com.sgenlecroyant.kafka.microservice.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.producer.OrderProducer;
import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;
import com.sgenlecroyant.kafka.microservice.service.repository.OrderItemRepository;
import com.sgenlecroyant.kafka.microservice.service.repository.OrderRepository;

@Component
public class OrderAction {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final OrderProducer orderProducer;
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;

	@Autowired
	public OrderAction(OrderProducer orderProducer, OrderRepository orderRepository,
			OrderItemRepository orderItemRepository) {
		this.orderProducer = orderProducer;
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
	}

	public Order saveAndSend(OrderRequest orderRequest) {
		Order orderFromRequest = OrderRequest.createOrderFromRequest(orderRequest);

		this.orderRepository.save(orderFromRequest);

		orderFromRequest.getItems().forEach((orderItem) -> {
			OrderItem constructedOrderItem = OrderItem.newBuilder(orderItem).build();
			constructedOrderItem.setOrder(orderFromRequest);
			this.orderItemRepository.save(constructedOrderItem);
			OrderMessage orderMessage = OrderMessage.newBuilder(constructedOrderItem, orderFromRequest).build();
			this.orderProducer.sendToKafka(orderMessage);
		});

		return orderFromRequest;
	}

}
