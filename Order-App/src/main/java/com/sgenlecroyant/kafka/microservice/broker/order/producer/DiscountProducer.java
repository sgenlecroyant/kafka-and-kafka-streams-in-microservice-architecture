package com.sgenlecroyant.kafka.microservice.broker.order.producer;

import com.sgenlecroyant.kafka.microservice.broker.order.message.DiscountMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DiscountProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public DiscountProducer(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendToKafka(DiscountMessage discountMessage) {

		this.kafkaTemplate.send("promotions-topic", discountMessage.getDiscountCode(), discountMessage)
				.handle((sendResult, exception) -> {
					if (exception != null) {
						throw new RuntimeException("Error sending Discount Message to Kafka");
					}
					return sendResult.getProducerRecord();
				});
	}
}
