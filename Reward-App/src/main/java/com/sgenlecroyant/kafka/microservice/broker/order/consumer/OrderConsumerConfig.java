package com.sgenlecroyant.kafka.microservice.broker.order.consumer;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;

@Configuration
public class OrderConsumerConfig {

	@Autowired
	private KafkaProperties kafkaProperties;

	@SuppressWarnings("resource")
	public ConsumerFactory<String, OrderMessage> getConsumerFactory() {
		Map<String, Object> consumerProperties = this.kafkaProperties.buildConsumerProperties();
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		String deserializerClassName = new JsonDeserializer<OrderMessage>(OrderMessage.class).getClass().getName();
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializerClassName);
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "hello-grp-id");
		return new DefaultKafkaConsumerFactory<>(consumerProperties);
	}

	@Bean(name = "orderMessageListenerContainer")
	public MessageListenerContainer getMessageListenerContainer() {
		ContainerProperties containerProps = new ContainerProperties("orders-topic");

		ConcurrentMessageListenerContainer<String, OrderMessage> concurrentMessageListenerContainer = new ConcurrentMessageListenerContainer<>(
				this.getConsumerFactory(), containerProps);
		concurrentMessageListenerContainer.setupMessageListener(new OrderConsumer());
		return concurrentMessageListenerContainer;
	}

}
