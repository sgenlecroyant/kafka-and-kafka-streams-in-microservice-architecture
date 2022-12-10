package com.sgenlecroyant.kafka.microservice.action;

import org.springframework.stereotype.Component;

import com.sgenlecroyant.kafka.microservice.api.server.request.PromotionRequest;
import com.sgenlecroyant.kafka.microservice.entity.Promotion;
import com.sgenlecroyant.kafka.microservice.repository.PromotionRepository;

@Component
public class PromotionAction {

	private final PromotionRepository promotionRepository;

	public PromotionAction(PromotionRepository promotionRepository) {
		this.promotionRepository = promotionRepository;
	}

	public Promotion createPromotionCode(PromotionRequest promotionRequest) {
		Promotion promotion = Promotion.newBuilder(promotionRequest).build();
		return this.promotionRepository.save(promotion);
	}

}
