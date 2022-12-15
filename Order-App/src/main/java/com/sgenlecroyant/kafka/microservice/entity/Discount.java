package com.sgenlecroyant.kafka.microservice.entity;

import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.order.builder.DiscountBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.RandomStringUtils;

@Entity(name = "discounts")
@Table(name = "discounts")
public class Discount {

	@Id
	private String id;
	private String discountCode;
	private Integer percentage;

	public Discount() {
	}

	public Discount(DiscountBuilder builder) {
		this.id = RandomStringUtils.randomAlphanumeric(10);
		this.discountCode = builder.getDiscountCode();
		this.percentage = builder.getPercentage();
	}

	public Integer getPercentage() {
		return percentage;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public String getId() {
		return id;
	}

	public static DiscountBuilder newBuilder(DiscountRequest discountRequest) {
		return new DiscountBuilder(discountRequest);
	}
}
