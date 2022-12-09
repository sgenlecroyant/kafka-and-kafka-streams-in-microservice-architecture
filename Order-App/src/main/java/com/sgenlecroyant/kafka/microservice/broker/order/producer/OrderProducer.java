package com.sgenlecroyant.kafka.microservice.broker.order.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;

@Component
public class OrderProducer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendToKafka(OrderMessage orderMessage) {
		this.kafkaTemplate.send("orders-topic", orderMessage.getOrderId(), orderMessage)
				.whenCompleteAsync((sendResult, exception) -> {
					if (exception != null) {
						this.logger.error("Exception Occurred while sending Order => {} to kafka. Error: {}",
								sendResult.getProducerRecord().value(), exception.getMessage());
					}
				});

	}

}
