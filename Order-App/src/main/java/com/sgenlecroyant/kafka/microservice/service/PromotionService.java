package com.sgenlecroyant.kafka.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.kafka.microservice.action.PromotionAction;
import com.sgenlecroyant.kafka.microservice.api.server.request.PromotionRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.PromotionMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.producer.PromotionCodeProducer;
import com.sgenlecroyant.kafka.microservice.entity.Promotion;

@Service
public class PromotionService {

	private final PromotionAction promotionAction;
	private final PromotionCodeProducer promotionCodeProducer;

	@Autowired
	public PromotionService(PromotionAction promotionAction, PromotionCodeProducer promotionCodeProducer) {
		this.promotionAction = promotionAction;
		this.promotionCodeProducer = promotionCodeProducer;
	}

	public Promotion createPromotionCodeAndSendToKafka(PromotionRequest promotionRequest) {
		Promotion promotion = this.promotionAction.createPromotionCode(promotionRequest);
		PromotionMessage promotionMessage = new PromotionMessage(promotion.getId(), promotion.getPromoCode());
		this.promotionCodeProducer.sendToKafka(promotionMessage);
		return promotion;
	}

}
