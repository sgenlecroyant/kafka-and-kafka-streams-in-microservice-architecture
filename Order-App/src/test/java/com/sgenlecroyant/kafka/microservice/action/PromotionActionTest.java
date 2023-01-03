package com.sgenlecroyant.kafka.microservice.action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sgenlecroyant.kafka.microservice.api.server.request.PromotionRequest;
import com.sgenlecroyant.kafka.microservice.entity.Promotion;
import com.sgenlecroyant.kafka.microservice.repository.PromotionRepository;

class PromotionActionTest {

	private PromotionRepository promotionRepository;
	private AutoCloseable autoCloseable;
	private PromotionAction promotionAction;

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		this.promotionRepository = mock(PromotionRepository.class);
		this.promotionAction = new PromotionAction(promotionRepository);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.autoCloseable.close();
	}

	@Test
	@DisplayName(value = "SHOULD CREATE PROMOTION CODE")
	void testCreatePromotionCode() {
		PromotionRequest promotionsRequest = new PromotionRequest();
		promotionsRequest.setPromotionCode("PROMO-2022");
		Promotion promotion = Promotion.newBuilder(promotionsRequest).build();
		ArgumentCaptor<Promotion> promotionArgumentCaptor = ArgumentCaptor
				.<Promotion, Promotion>forClass(Promotion.class);

		Mockito.when(this.promotionRepository.save(promotionArgumentCaptor.capture())).thenReturn(promotion);

		this.promotionAction.createPromotionCode(promotionsRequest);

		Promotion capturedPromotion = promotionArgumentCaptor.getValue();
		assertThat(promotion.getPromoCode()).isEqualTo(capturedPromotion.getPromoCode());
		verify(this.promotionRepository, times(1)).save(capturedPromotion);
	}

}
