package com.sgenlecroyant.kafka.microservice.order.builder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sgenlecroyant.kafka.microservice.api.server.request.PromotionRequest;
import com.sgenlecroyant.kafka.microservice.entity.Promotion;

class PromotionBuilderTest {

	private PromotionRequest promotionRequest;
	private PromotionBuilder promotionBuilder;

	@BeforeEach
	void setUp() {
		this.promotionRequest = new PromotionRequest();
		this.promotionRequest.setPromotionCode("PROMO-2022");
		this.promotionBuilder = new PromotionBuilder(this.promotionRequest);
	}

	@Test
	@DisplayName(value = "SHOULD BUILD PROMOTION INSTANCE")
	public void shouldBuildPromotion() {
		Promotion promotion = this.promotionBuilder.build();
		assertThat(promotion).isNotNull();
	}

}
