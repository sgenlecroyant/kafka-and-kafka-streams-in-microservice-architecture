package com.sgenlecroyant.kafka.microservice.exception;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("orderErrorHandler")
public class InvalidOrderCreditcardException implements ConsumerAwareListenerErrorHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public void handleOtherException(Exception thrownException, Consumer<?, ?> consumer,
			MessageListenerContainer container, boolean batchListener) {
		this.logger.error("Error while consumming message: {}", container);
	}

//	@Override
	public void handleRecord(Exception thrownException, ConsumerRecord<?, ?> record, Consumer<?, ?> consumer,
			MessageListenerContainer container) {
		this.logger.error("Error while consumming message: {}", record.value());

	}

//	@Override
	public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
		this.logger.error("Error while consumming message: {}", data.value());

	}

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {

		this.logger.error("Error while consumming message: {}", message.getPayload());

		return null;
	}

}
