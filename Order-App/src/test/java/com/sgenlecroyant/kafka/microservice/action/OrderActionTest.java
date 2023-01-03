package com.sgenlecroyant.kafka.microservice.action;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.broker.order.message.OrderMessage;
import com.sgenlecroyant.kafka.microservice.broker.order.producer.OrderProducer;
import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.entity.OrderItem;
import com.sgenlecroyant.kafka.microservice.repository.OrderItemRepository;
import com.sgenlecroyant.kafka.microservice.repository.OrderRepository;

@ExtendWith(value = MockitoExtension.class)
class OrderActionTest {

	private AutoCloseable autoCloseable;
	@Mock
	private OrderProducer orderProducer;
	@Mock
	private OrderRepository orderRepository;
	@Mock
	private OrderItemRepository orderItemRepository;

	@InjectMocks
	private OrderAction orderAction;

	@BeforeEach
	void setUp() throws Exception {
		this.autoCloseable = MockitoAnnotations.openMocks(this);

	}

	@AfterEach
	void tearDown() throws Exception {
		this.autoCloseable.close();
	}

	@Test
	void testSaveAndSend() {
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setCreditCardNumber("1234-345-231-567");
		orderRequest.setLocation("France");

		Order createdOrder = OrderRequest.createOrderFromRequest(orderRequest);

		Order order = new Order();
		order.setCreditCardNumber(orderRequest.getCreditCardNumber());
		order.setId("order-> 12345");

		OrderItem orderItem = new OrderItem();
		orderItem.setId("order-item-> 12345");
		orderItem.setName("Samsung");
		orderItem.setPrice(12345d);
		orderItem.setQuantity(23); 
		orderItem.setOrder(order);

		orderRequest.setItems(List.<OrderItem>of(orderItem));

		order.setItems(List.<OrderItem>of(orderItem));

		ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.<Order, Order>forClass(Order.class);

		ArgumentCaptor<OrderRequest> orderRequestArgumentCaptor = ArgumentCaptor.forClass(OrderRequest.class);

		Mockito.when(this.orderRepository.save(orderArgumentCaptor.capture())).thenReturn(order);

		orderRequest.getItems().stream().forEach((item) -> {
			ArgumentCaptor<OrderItem> orderItemArgumentCaptor = ArgumentCaptor.forClass(OrderItem.class);
			Mockito.when(this.orderItemRepository.save(orderItemArgumentCaptor.capture())).thenReturn(orderItem);
		});

		OrderMessage orderMessage = OrderMessage.newBuilder(orderItem, order).build();

		this.orderAction.saveAndSend(orderRequestArgumentCaptor.capture());
		assertTrue(true);

	}

}
