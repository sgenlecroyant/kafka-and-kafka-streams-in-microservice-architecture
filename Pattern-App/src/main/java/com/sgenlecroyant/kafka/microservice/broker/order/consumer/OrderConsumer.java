package com.sgenlecroyant.kafka.microservice.broker.order.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;

@Component
public class OrderConsumer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@KafkaListener(topics = "orders-topic")
	public void streamOrders(OrderMessage orderMessage) {

		this.logger.info("Received Order: {} ", orderMessage.getOrderId());
	}

}
