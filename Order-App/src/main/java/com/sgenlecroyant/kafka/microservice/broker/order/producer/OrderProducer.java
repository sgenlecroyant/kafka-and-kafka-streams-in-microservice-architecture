package com.sgenlecroyant.kafka.microservice.broker.order.producer;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.apache.kafka.common.serialization.BytesSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;

@Component
public class OrderProducer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private KafkaTemplate<String, OrderMessage> kafkaTemplate;

	@Autowired
	public OrderProducer(KafkaTemplate<String, OrderMessage> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public ProducerRecord<String, OrderMessage> buildOrderMessageWithHeaders(OrderMessage orderMessage) {
		List<Header> headers = new ArrayList<>();
		int bonusValue = orderMessage.getLocation().startsWith("burundi") ? 40 : 10;
		RecordHeader surpriseBonus = new RecordHeader("bonus", Integer.toString(bonusValue).getBytes());
		headers.add(surpriseBonus);

		ProducerRecord<String, OrderMessage> producerRecord = new ProducerRecord<String, OrderMessage>("orders-topic",
				null, orderMessage.getOrderId(), orderMessage, headers);
		return producerRecord;
	}

	public void sendToKafka(OrderMessage orderMessage) {
		ProducerRecord<String, OrderMessage> producerRecord = this.buildOrderMessageWithHeaders(orderMessage);
		this.kafkaTemplate.send(producerRecord).whenCompleteAsync((sendResult, exception) -> {
			if (exception != null) {
				this.logger.error("Exception Occurred while sending Order => {} to kafka. Error: {}",
						sendResult.getProducerRecord().value(), exception.getMessage());
			} else {
				this.logger.info("ORDER PLACED!");
			}
		});

	}


}
