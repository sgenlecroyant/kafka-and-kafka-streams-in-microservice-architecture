package com.sgenlecroyant.kafka.microservice.order.builder;

import com.sgenlecroyant.kafka.microservice.api.server.response.DiscountRespone;
import com.sgenlecroyant.kafka.microservice.entity.Discount;

public class DiscountResponseBuilder {
	
	private String discountCode;
	private Integer percentage;
	
	public DiscountResponseBuilder(Discount discount) {
		this.discountCode = discount.getDiscountCode();
		this.percentage = discount.getPercentage();
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public Integer getPercentage() {
		return percentage;
	}
	
	public DiscountRespone build() {
		return new DiscountRespone(this);
	}
}
