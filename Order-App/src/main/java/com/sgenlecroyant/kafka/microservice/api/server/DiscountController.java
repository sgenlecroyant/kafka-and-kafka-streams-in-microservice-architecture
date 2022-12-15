package com.sgenlecroyant.kafka.microservice.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.api.server.response.DiscountRespone;
import com.sgenlecroyant.kafka.microservice.service.DiscountService;

@RestController
@RequestMapping(path = "/order-app/api/v1")
public class DiscountController {

	private final DiscountService discountService;

	@Autowired
	public DiscountController(DiscountService discountService) {
		this.discountService = discountService;
	}

	@PostMapping(path = "/discounts")
	public ResponseEntity<DiscountRespone> createDiscount(@RequestBody DiscountRequest discountRequest) {
		DiscountRespone discountRespone = this.discountService.saveAndSendToKafka(discountRequest);

		return new ResponseEntity<DiscountRespone>(discountRespone, HttpStatus.OK);
	}

}
