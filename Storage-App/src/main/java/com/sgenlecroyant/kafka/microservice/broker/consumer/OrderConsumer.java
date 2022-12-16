package com.sgenlecroyant.kafka.microservice.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;

@Component
public class OrderConsumer {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@KafkaListener(topics = "orders-topic")
	public void streamOrders(ConsumerRecord<String, OrderMessage> orderMessageConsumerRecord) {
		Header bonusHeader = orderMessageConsumerRecord.headers().lastHeader("bonus");
		String bonusHeaderKey = bonusHeader.key();
		Integer bonusPoints = Integer.valueOf(new String(bonusHeader.value()));
		this.logger.info("Key: {}, Value: {}", bonusHeaderKey, bonusPoints);
	}

}
