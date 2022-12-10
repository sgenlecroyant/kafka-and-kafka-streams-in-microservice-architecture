package com.sgenlecroyant.kafka.microservice.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.kafka.microservice.api.server.request.PromotionRequest;
import com.sgenlecroyant.kafka.microservice.api.server.response.PromotionResponse;
import com.sgenlecroyant.kafka.microservice.service.PromotionService;

@RestController
@RequestMapping(value = "/order-app/api/v1")
public class PromotionController {

	private final PromotionService promotionService;

	@Autowired
	public PromotionController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}

	@PostMapping(value = "/promotions")
	private ResponseEntity<PromotionResponse> createPromotion(@RequestBody PromotionRequest promotionRequest) {
		PromotionResponse response = new PromotionResponse(promotionRequest.getPromotionCode());
		this.promotionService.createPromotionCodeAndSendToKafka(promotionRequest);
		return new ResponseEntity<PromotionResponse>(response, HttpStatus.OK);
	}

}
