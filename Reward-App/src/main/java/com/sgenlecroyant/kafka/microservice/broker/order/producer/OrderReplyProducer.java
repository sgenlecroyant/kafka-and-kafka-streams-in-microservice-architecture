package com.sgenlecroyant.kafka.microservice.broker.order.producer;

public class OrderReplyProducer {

//	private KafkaTemplate<String, OrderReply> kafkaTemplate = new KafkaTemplate<>(this.getProducerFactory());
//
//	public void replyAfterOrderProcessing(OrderReply orderReply) {
//		this.kafkaTemplate.send("orders-reply", orderReply);
//	}
//
//	public ProducerFactory<String, OrderReply> getProducerFactory() {
//		Map<String, Object> producerProps = new HashMap<>();
//		producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OrderReplySerializer.class);
//		return new DefaultKafkaProducerFactory<>(producerProps);
//	}

}
