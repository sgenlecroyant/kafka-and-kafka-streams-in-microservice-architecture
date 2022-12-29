package com.sgenlecroyant.kafka.microservice.order.builder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.api.server.response.DiscountRespone;
import com.sgenlecroyant.kafka.microservice.entity.Discount;

class DiscountResponseBuilderTest {

	private DiscountRespone discountRespone;
	private DiscountResponseBuilder discountResponseBuilder;
	private DiscountRequest discountRequest;

	@BeforeEach
	void setUp() throws Exception {
		discountRequest = new DiscountRequest();
		discountRequest.setDiscountCode("SPRINGO2020");
		discountRequest.setPercentage(30);

		Discount discount = Discount.newBuilder(discountRequest).build();

		discountResponseBuilder = new DiscountResponseBuilder(discount);
		this.discountRespone = new DiscountRespone(discountResponseBuilder);

	}

	@Test
	@DisplayName(value = "SHOULD-TEST-IF-DISCOUNT-RESPONSE-BUILDER-WORKS")
	void shouldBuildDiscountResponse() {
		assertThat(this.discountRequest).satisfies((request) -> {
			assertThat(request.getDiscountCode()).isEqualTo(discountRespone.getDiscountCode());
			assertThat(request.getPercentage()).isEqualTo(discountRespone.getPercentage());
		});

		assertThat(discountResponseBuilder.build().getDiscountCode()).isEqualTo(discountRespone.getDiscountCode());
	}

}
