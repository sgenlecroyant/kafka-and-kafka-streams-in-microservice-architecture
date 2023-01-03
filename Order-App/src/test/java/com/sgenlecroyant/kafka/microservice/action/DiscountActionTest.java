package com.sgenlecroyant.kafka.microservice.action;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.DiscountMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.producer.DiscountProducer;
import com.sgenlecroyant.kafka.microservice.entity.Discount;
import com.sgenlecroyant.kafka.microservice.repository.DiscountRepository;

class DiscountActionTest {

	private DiscountRepository discountRepository;
	private DiscountProducer discountProducer;
	private DiscountAction discountAction;
	private AutoCloseable autoCloseable;

	@BeforeEach
	void setUp() throws Exception {
		this.autoCloseable = MockitoAnnotations.openMocks(this);
		this.discountRepository = Mockito.mock(DiscountRepository.class);
		this.discountProducer = Mockito.mock(DiscountProducer.class);
		this.discountAction = new DiscountAction(discountRepository, discountProducer);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.autoCloseable.close();
	}

	@Test
//	@DisplayName(value = "SHOULD CREATE DISCOUNT AND SEND TO KAFKA")
	void testCreateDiscountAndSendToKafka() {
		DiscountRequest discountRequest = new DiscountRequest();
		discountRequest.setDiscountCode("RUNAWAY-2020");
		discountRequest.setPercentage(30);
		Discount discount = Discount.newBuilder(discountRequest).build();

		DiscountMessage discountMessage = this.discountAction.buildDiscountMessage(discount);
		ArgumentCaptor<Discount> discountArgumentCaptor = ArgumentCaptor.<Discount, Discount>forClass(Discount.class);

		ArgumentCaptor<DiscountMessage> discountMessageArgumentCaptor = ArgumentCaptor
				.<DiscountMessage, DiscountMessage>forClass(DiscountMessage.class);
		Mockito.when(this.discountRepository.save(discountArgumentCaptor.capture())).thenReturn(discount);
		this.discountAction.createDiscountAndSendToKafka(discountRequest);
		Mockito.verify(this.discountProducer, times(1)).sendToKafka(discountMessageArgumentCaptor.capture());
	}

}
