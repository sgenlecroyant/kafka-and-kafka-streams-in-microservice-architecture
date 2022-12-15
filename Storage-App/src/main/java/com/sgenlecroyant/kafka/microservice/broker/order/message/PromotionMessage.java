package com.sgenlecroyant.kafka.microservice.broker.order.message;

public class PromotionMessage {

	private String id;
	private String promotionCode;

	public PromotionMessage() {

	}

	public PromotionMessage(String id, String promotionCode) {
		this.id = id;
		this.promotionCode = promotionCode;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PromotionMessage [id=" + id + ", promotionCode=" + promotionCode + "]";
	}

}
