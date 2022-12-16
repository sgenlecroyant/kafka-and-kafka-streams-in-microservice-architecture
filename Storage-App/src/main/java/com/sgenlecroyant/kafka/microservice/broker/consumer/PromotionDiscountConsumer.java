package com.sgenlecroyant.kafka.microservice.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.kafka.microservice.broker.order.message.DiscountMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.message.PromotionMessage;

@Service
@KafkaListener(topics = "promotions-topic")
public class PromotionDiscountConsumer {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@KafkaHandler
	public void streamPromotions(PromotionMessage promotionMessage) {
		this.logger.info("promotion message: {}", promotionMessage);
	}

	@KafkaHandler
	public void streamDiscounts(DiscountMessage discountMessage) {
		this.logger.info("discount message: {}", discountMessage);

	}
}
