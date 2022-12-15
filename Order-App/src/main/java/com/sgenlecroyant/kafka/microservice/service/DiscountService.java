package com.sgenlecroyant.kafka.microservice.service;

import org.springframework.stereotype.Service;

import com.sgenlecroyant.kafka.microservice.action.DiscountAction;
import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.api.server.response.DiscountRespone;
import com.sgenlecroyant.kafka.microservice.entity.Discount;

@Service
public class DiscountService {

	private final DiscountAction discountAction;

	public DiscountService(DiscountAction discountAction) {
		this.discountAction = discountAction;
	}

	public DiscountRespone saveAndSendToKafka(DiscountRequest discountRequest) {
		Discount discount = this.discountAction.createDiscountAndSendToKafka(discountRequest);
		return DiscountRespone.newBuilder(discount).build();
	}

}
