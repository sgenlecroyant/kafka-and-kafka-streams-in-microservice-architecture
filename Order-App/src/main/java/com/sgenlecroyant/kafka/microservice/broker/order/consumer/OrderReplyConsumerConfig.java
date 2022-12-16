package com.sgenlecroyant.kafka.microservice.broker.order.consumer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderReply;

@Component
public class OrderReplyConsumerConfig {

//	@Autowired
	private KafkaProperties kafkaProperties;

//	@Bean
	public ConsumerFactory<String, OrderReply> getConsumerFactory() {
		Map<String, Object> consumerProperties = this.kafkaProperties.buildConsumerProperties();
		return new DefaultKafkaConsumerFactory<>(consumerProperties);
	}

//	@Bean
	public ContainerProperties getContainerProperties() {
		ContainerProperties containerProperties = new ContainerProperties("orders-reply");
		return containerProperties;
	}

//	@Bean
	public MessageListenerContainer getMessageListenerContainer(ContainerProperties containerProperties) {
		KafkaMessageListenerContainer<String, OrderReply> kafkaMessageListenerContainer = new KafkaMessageListenerContainer<>(
				this.getConsumerFactory(), containerProperties);
		kafkaMessageListenerContainer.setupMessageListener(new OrderReplyConsumer());
		return kafkaMessageListenerContainer;
	}

}
