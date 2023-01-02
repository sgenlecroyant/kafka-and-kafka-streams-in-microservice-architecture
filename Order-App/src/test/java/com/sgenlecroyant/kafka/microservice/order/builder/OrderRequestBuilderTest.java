package com.sgenlecroyant.kafka.microservice.order.builder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;

class OrderRequestBuilderTest {

	private OrderRequest orderRequest;
	private OrderRequestBuilder orderRequestBuilder;
	private Order order;
	private OrderItem orderItem;

	@BeforeEach
	void setUp() throws Exception {
		this.orderRequest = new OrderRequest();
		String creditCardNumber = "public ";
		String location = "France";

		this.orderRequest.setCreditCardNumber(creditCardNumber);
		this.orderRequest.setLocation(location);

		String itemName = "Samsung";
		Double price = 1200d;
		Integer quantity = 23;

		orderItem = OrderItem.newBuilder().name(itemName).price(price).withQuantity(quantity).build();
		this.orderRequest.setItems(List.of(orderItem));

		order = Order.create(orderRequest);
		orderItem.setOrder(order);
		orderRequestBuilder = new OrderRequestBuilder(orderRequest);

	}

	@Test
	void testOrderRequestBuilder() {
		assertThat(this.orderRequestBuilder).satisfies((builder) -> {
			assertThat(builder.getCreditCardNumber()).isEqualTo(orderRequest.getCreditCardNumber());
			assertThat(builder.getLocation()).isEqualTo(orderRequest.getLocation());
			assertThat(builder.getItems().size()).isEqualTo(orderRequest.getItems().size());
		});
	}

	@Test
	void testLocation() {
		assertThat(orderRequest.getLocation()).isEqualTo(order.getLocation());
	}

	@Test
	void testWithCreditcardNumber() {
		assertThat(this.orderRequest.getCreditCardNumber()).isEqualTo(order.getCreditCardNumber())
				.isEqualTo(orderItem.getOrder().getCreditCardNumber())
				.isEqualTo(orderRequestBuilder.getCreditCardNumber());
	}

	@Test
	void testGetCreditCardNumber() {
		assertThat(this.orderRequestBuilder.getCreditCardNumber()).isEqualTo(orderRequest.getCreditCardNumber());
	}

	@Test
	void testGetLocation() {
		assertThat(this.orderRequestBuilder.getLocation()).isEqualTo(orderRequest.getLocation());
	}

	@Test
	void testGetItems() {
		assertThat(this.orderRequestBuilder.getItems().size()).isEqualByComparingTo(orderRequest.getItems().size());
	}

}
