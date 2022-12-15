package com.sgenlecroyant.kafka.microservice.order.builder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.entity.Discount;

class DiscountBuilderTest {

	private DiscountBuilder builder;
	private DiscountRequest discountRequest;

	@BeforeEach
	public void setUp() {
		this.discountRequest = new DiscountRequest();
		this.discountRequest.setDiscountCode("SPRING");
		this.discountRequest.setPercentage(30);

	}

	@Test
	void testDiscountBuilder() {
		this.builder = new DiscountBuilder(discountRequest);
		assertThat(builder).isNotNull().hasNoNullFieldsOrProperties();
	}

	@Test
	void testGetPercentage() {
		this.builder = new DiscountBuilder(discountRequest);
		assertThat(builder.getPercentage()).isEqualTo(30);
	}

	@Test
	void testGetDiscountCode() {
		this.builder = new DiscountBuilder(discountRequest);
		assertThat(builder.getDiscountCode()).isEqualTo("SPRING");
	}

	@Test
	void testBuilds() {
		this.builder = new DiscountBuilder(discountRequest);
		Discount discount = builder.build();
		assertThat(discount.getDiscountCode()).isEqualTo(builder.getDiscountCode());
		assertThat(discount.getPercentage()).isEqualTo(builder.getPercentage());
	}

	@Test
	void testCode() {
		this.builder = new DiscountBuilder(discountRequest);
		Discount discount = builder.code("new-code").build();
		assertThat(discount.getDiscountCode()).isEqualTo("new-code");
	}

	@Test
	void testPercentage() {
		this.builder = new DiscountBuilder(discountRequest);
		Discount discount = builder.percentage(80).build();
		assertThat(discount.getPercentage()).isEqualTo(80);
	}

}
