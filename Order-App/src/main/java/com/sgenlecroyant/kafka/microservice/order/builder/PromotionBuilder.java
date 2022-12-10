package com.sgenlecroyant.kafka.microservice.order.builder;

import com.sgenlecroyant.kafka.microservice.api.server.request.PromotionRequest;
import com.sgenlecroyant.kafka.microservice.entity.Promotion;

public class PromotionBuilder {

	private String id;
	private String promoCode;

	public PromotionBuilder(PromotionRequest promotionRequest) {
		this.promoCode = promotionRequest.getPromotionCode();
	}

	public PromotionBuilder code(String promoCode) {
		this.promoCode = promoCode;
		return this;
	}

	public String getId() {
		return id;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public Promotion build() {
		return new Promotion(this);
	}

}
