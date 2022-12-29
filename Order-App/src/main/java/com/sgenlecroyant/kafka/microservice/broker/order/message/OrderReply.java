package com.sgenlecroyant.kafka.microservice.broker.order.message;

public class OrderReply {

	private String message;
	
	public OrderReply() {
		// TODO Auto-generated constructor stub
	}

	public OrderReply(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OrderReply [message=" + message + "]";
	}

}
