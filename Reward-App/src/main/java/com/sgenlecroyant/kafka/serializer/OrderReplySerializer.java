package com.sgenlecroyant.kafka.serializer;

import java.io.UncheckedIOException;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderReply;

public class OrderReplySerializer implements Serializer<OrderReply>{

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public byte[] serialize(String topic, OrderReply data) {
		try {
			return this.objectMapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			throw new UncheckedIOException(e);
		}
	}

}
