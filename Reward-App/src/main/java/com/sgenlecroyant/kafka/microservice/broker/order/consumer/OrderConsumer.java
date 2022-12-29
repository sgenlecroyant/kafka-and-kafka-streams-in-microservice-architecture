package com.sgenlecroyant.kafka.microservice.broker.order.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderReply;

@Component
public class OrderConsumer implements AcknowledgingConsumerAwareMessageListener<String, OrderMessage> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private KafkaTemplate<String, OrderReply> kafkaTemplate = new KafkaTemplate<>(this.getProducerFactory());

	@Override
	public void onMessage(ConsumerRecord<String, OrderMessage> data, Acknowledgment acknowledgment,
			Consumer<?, ?> consumer) {
		this.logger.info("Consumed Order Message: {}", data.value());
		System.out.println("IS KAFKA TEMPLATE NULL: " + (kafkaTemplate == null));
		OrderMessage orderMessage = data.value();
		OrderReply orderReply = new OrderReply(
				String.format("Order with ID: %s has been processed successfully!", orderMessage.getOrderId()));
		this.kafkaTemplate.send("orders-reply", orderReply);
	}

	@SuppressWarnings("resource")
	private ProducerFactory<String, OrderReply> getProducerFactory() {
		Map<String, Object> producerProps = new HashMap<>();
		producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				new JsonSerializer<>(new TypeReference<OrderReply>() {
				}).getClass().getName());
		return new DefaultKafkaProducerFactory<>(producerProps);
	}

//	@KafkaListener(topics = "orders-topic")
//	@SendTo("orders-reply")
//	public OrderReply streamOrders(OrderMessage orderMessage) {
//		OrderReply orderReply = new OrderReply(
//				String.format("Order with ID: %s has been processed successfully!", orderMessage.getOrderId()));
//		this.logger.info("Order processed {}", orderMessage);
//		return orderReply;
//	}

}
