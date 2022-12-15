package com.sgenlecroyant.kafka.microservice.api.server.response;

import com.sgenlecroyant.kafka.microservice.entity.Discount;
import com.sgenlecroyant.kafka.microservice.order.builder.DiscountResponseBuilder;

public class DiscountRespone {

	private String discountCode;
	private Integer percentage;

	public DiscountRespone(DiscountResponseBuilder discountResponseBuilder) {
		this.discountCode = discountResponseBuilder.getDiscountCode();
		this.percentage = discountResponseBuilder.getPercentage();
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public static DiscountResponseBuilder newBuilder(Discount discount) {
		return new DiscountResponseBuilder(discount);
	}

}
