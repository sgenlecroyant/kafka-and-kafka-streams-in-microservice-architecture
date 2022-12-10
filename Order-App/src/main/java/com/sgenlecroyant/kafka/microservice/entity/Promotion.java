package com.sgenlecroyant.kafka.microservice.entity;

import org.apache.commons.lang3.RandomStringUtils;

import com.sgenlecroyant.kafka.microservice.api.server.request.PromotionRequest;
import com.sgenlecroyant.kafka.microservice.order.builder.PromotionBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "promotions")
@Table(name = "promotions")
public class Promotion {

	@Id
	private String id;
	private String promoCode;

	public Promotion() {
		// TODO Auto-generated constructor stub
	}

	public Promotion(PromotionBuilder builder) {
		this.id = RandomStringUtils.randomNumeric(5);
		this.promoCode = builder.getPromoCode();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public static PromotionBuilder newBuilder(PromotionRequest promotionRequest) {

		return new PromotionBuilder(promotionRequest);
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", promoCode=" + promoCode + "]";
	}

}
