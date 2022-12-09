package com.sgenlecroyant.kafka.microservice.entity;

import java.util.List;

import com.sgenlecroyant.kafka.microservice.api.server.request.OrderRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "orders")
@Table(name = "orders")
public class Order {

	@Id
	private String id;
	private String creditCardNumber;
	private String location;

	@OneToMany(mappedBy = "order", targetEntity = OrderItem.class)
	private List<OrderItem> items;

	public Order() {

	}

	public String getId() {
		return id;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getLocation() {
		return location;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public static Order create(OrderRequest orderRequest) {
		return OrderRequest.createOrderFromRequest(orderRequest);
	}

}
