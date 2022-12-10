package com.sgenlecroyant.kafka.microservice.broker.order.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.entity.Promotion;

@Component
public class PromotionCodeProducer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final KafkaTemplate<String, Promotion> kafkaTemplate;

	@Autowired
	public PromotionCodeProducer(KafkaTemplate<String, Promotion> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendToKafka(Promotion promotion) {
		this.kafkaTemplate.send(new ProducerRecord<String, Promotion>("promotions-topic", promotion.getId(), promotion))
				.handleAsync((sendResult, exception) -> {
					if (exception != null) {
						this.logger.error("Error producing PromoCode {} to KAFKA, Error: {}", promotion.getPromoCode(),
								exception.getMessage());
						throw new RuntimeException(exception.getMessage());
					}
					return sendResult.getProducerRecord();
				}).thenRunAsync(() -> {
					this.logger.info("PROMOTION_CODE SENT TO KAFKA");
				});
	}

}
