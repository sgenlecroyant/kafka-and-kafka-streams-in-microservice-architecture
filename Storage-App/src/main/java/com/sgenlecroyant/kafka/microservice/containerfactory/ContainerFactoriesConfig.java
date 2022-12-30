package com.sgenlecroyant.kafka.microservice.containerfactory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class ContainerFactoriesConfig {

	@Autowired
	private KafkaProperties kafkaProperties;

	public ConsumerFactory<Object, Object> getOrdersConsumerFactory() {
		Map<String, Object> consumerProperties = this.kafkaProperties.buildConsumerProperties();
		return new DefaultKafkaConsumerFactory<>(consumerProperties);
	}

	@Bean("orderContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> getOrdersConcurrentKafkaListenerContainerFactory(
			ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {

		ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		configurer.configure(factory, this.getOrdersConsumerFactory());
		
		
		return factory;

	}

}

