package com.sgenlecroyant.kafka.microservice.model;

public class OrderReply {

	private String message;

	public OrderReply(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
