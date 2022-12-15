package com.sgenlecroyant.kafka.microservice.action;

import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.DiscountMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.producer.DiscountProducer;
import com.sgenlecroyant.kafka.microservice.entity.Discount;
import com.sgenlecroyant.kafka.microservice.repository.DiscountRepository;

@Component
public class DiscountAction {

	private final DiscountRepository discountRepository;
	private final DiscountProducer discountProducer;

	public DiscountAction(DiscountRepository discountRepository, DiscountProducer discountProducer) {
		this.discountRepository = discountRepository;
		this.discountProducer = discountProducer;
	}

	public Discount createDiscountAndSendToKafka(DiscountRequest discountRequest) {

		Discount discount = Discount.newBuilder(discountRequest).build();
		Discount savedDiscount = this.discountRepository.save(discount);
		DiscountMessage discountMessage = this.buildDiscountMessage(savedDiscount);
		this.discountProducer.sendToKafka(discountMessage);
		return savedDiscount;
	}

	private DiscountMessage buildDiscountMessage(Discount discount) {
		DiscountMessage discountMessage = new DiscountMessage(discount.getDiscountCode(), discount.getPercentage());
		return discountMessage;
	}

}
