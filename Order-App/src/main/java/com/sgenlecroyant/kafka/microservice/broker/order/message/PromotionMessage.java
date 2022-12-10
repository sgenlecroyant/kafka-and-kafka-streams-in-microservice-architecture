package com.sgenlecroyant.kafka.microservice.broker.order.message;

public class PromotionMessage {

	private String promotionCode;

	public PromotionMessage() {
		// TODO Auto-generated constructor stub
	}

	public PromotionMessage(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

}