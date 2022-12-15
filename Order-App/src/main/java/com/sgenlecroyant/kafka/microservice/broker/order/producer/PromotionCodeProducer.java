package com.sgenlecroyant.kafka.microservice.broker.order.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.broker.order.message.PromotionMessage;

@Component
public class PromotionCodeProducer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final KafkaTemplate<String, PromotionMessage> kafkaTemplate;

	@Autowired
	public PromotionCodeProducer(KafkaTemplate<String, PromotionMessage> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendToKafka(PromotionMessage promotionMessage) {
		this.kafkaTemplate.send(new ProducerRecord<String, PromotionMessage>("promotions-topic",
				promotionMessage.getId(), promotionMessage)).handleAsync((sendResult, exception) -> {
					if (exception != null) {
						this.logger.error("Error producing PromoCode {} to KAFKA, Error: {}", promotionMessage.getId(),
								exception.getMessage());
						throw new RuntimeException(exception.getMessage());
					}
					return sendResult.getProducerRecord();
				}).thenRunAsync(() -> {
					this.logger.info("PROMOTION_CODE SENT TO KAFKA");
				});
	}

}
