package com.sgenlecroyant.kafka.microservice.broker.order.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.AbstractKafkaListenerContainerFactory;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderReply;

@Component
public class OrderReplyConsumer implements MessageListener<String, OrderReply> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onMessage(ConsumerRecord<String, OrderReply> data) {
		this.logger.info("OrderReply Received: {}", data.value());
	}
//	@KafkaListener(topics = "orders-reply")
//	public void streamOrdersReply(Message<OrderReply> orderReply) {
//		this.logger.info("reply: => {}", orderReply);
//	}

}
