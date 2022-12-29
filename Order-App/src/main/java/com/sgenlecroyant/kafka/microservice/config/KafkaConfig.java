package com.sgenlecroyant.kafka.microservice.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.BytesJsonMessageConverter;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
@EnableKafka
public class KafkaConfig {

	@Autowired
	private KafkaProperties kafkaProperties;

//	@Bean
	public RecordMessageConverter recordMessageConverter() {
		return new BytesJsonMessageConverter();
	}

	public ConsumerFactory<Object, Object> consumerFactory() {
		Map<String, Object> consumerProperties = this.kafkaProperties.buildConsumerProperties();
		return new DefaultKafkaConsumerFactory<>(consumerProperties);
	}

//	@Bean
	public KafkaListenerContainerFactory<?> kafkaJsonListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setMessageConverter(new JsonMessageConverter());
		
		return factory;
	}

}

