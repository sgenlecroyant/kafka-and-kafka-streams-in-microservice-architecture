package com.sgenlecroyant.kafka.microservice.api.server.response;

public class PromotionResponse {

	private String promotionCode;

	public PromotionResponse(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

}
