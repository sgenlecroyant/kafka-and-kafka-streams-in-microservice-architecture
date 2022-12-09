package com.sgenlecroyant.kafka.microservice.api.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;
import com.sgenlecroyant.kafka.microservice.api.server.response.OrderResponse;
import com.sgenlecroyant.kafka.microservice.entity.Order;
import com.sgenlecroyant.kafka.microservice.service.OrderService;

@RestController
@RequestMapping(path = "/order-app/api/v1/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
		
		Order order = this.orderService.saveAndSend(orderRequest);
		OrderResponse orderResponse = OrderResponse.createOrderResponse(order);
		return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
	}

}
