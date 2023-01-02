package com.sgenlecroyant.kafka.microservice.order.builder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;
import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;

class OrderMessageBuilderTest {

	private OrderMessageBuilder orderMessageBuilder;
	private OrderItem orderItem;
	private Order order;
	private OrderRequest orderRequest;
	private OrderRequestBuilder orderRequestBuilder;
	private OrderMessage orderMessage;

	@BeforeEach
	public void setUp() {

		this.orderRequest = new OrderRequest();
		String creditCardNumber = "public ";
		String location = "France";

		this.orderRequest.setCreditCardNumber(creditCardNumber);
		this.orderRequest.setLocation(location);

		String itemName = "Samsung";
		Double price = 1200d;
		Integer quantity = 23;

		this.orderItem = OrderItem.newBuilder().name(itemName).price(price).withQuantity(quantity).build();
		this.orderRequest.setItems(List.of(orderItem));

		this.order = Order.create(orderRequest);
		this.orderItem.setOrder(order);
		this.orderRequestBuilder = new OrderRequestBuilder(orderRequest);

		this.orderMessageBuilder = new OrderMessageBuilder(orderItem, order);
		orderMessage = this.orderMessageBuilder.build();
	}

	@Test
	@DisplayName(value = "SHOULD BUILD OrderMessage FROM OrderMessageBuilder")
	public void testOrderMessageBuilder() {
		assertThat(orderMessage).isNotNull();
	}

	@Test
	@DisplayName(value = "SHOULD RETURN THE SAME ORDER ID")
	// @formatter:off
	public void testGetOrderId() {
		assertThat(this.orderMessage)
					.satisfies((inputOrderMessage) -> {
						assertThat(inputOrderMessage.getOrderId())
							.isEqualTo(this.order.getId())
							.isEqualTo(this.orderItem.getOrder().getId());
					});
	}

	@Test
	@DisplayName(value = "SHOULD RETURN THE ORDER ITEM NAME")
	public void testGetName() {
		
		assertThat(this.orderMessage)
		.satisfies((inputOrderMessage) -> {
			assertThat(inputOrderMessage.getName())
				.isEqualTo(this.orderItem.getName());
		});
	}

	@Test
	public void testGetPrice() {
	}

	@Test
	public void testGetQuantity() {
	}

	@Test
	public void testGetCreditCardNumber() {
	}

	@Test
	public void testGetLocation() {
	}

	@Test
	public void testGetItemId() {
	}

	@Test
	public void testBuild() {
	}

}
