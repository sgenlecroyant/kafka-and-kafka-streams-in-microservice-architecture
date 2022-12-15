package com.sgenlecroyant.kafka.microservice.api.server.request;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountRequestTest {

	DiscountRequest request;
	private final static String code = "SPRINGO-READY";
	private final static Integer percentage = 30;

	@BeforeEach
	void setUp() {
		this.request = new DiscountRequest();
		this.request.setDiscountCode(code);
		this.request.setPercentage(percentage);
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	public void shouldHaveNonNullFieldExceptId() {

		assertThat(request).hasNoNullFieldsOrPropertiesExcept("id").isInstanceOf(DiscountRequest.class);
	}
}