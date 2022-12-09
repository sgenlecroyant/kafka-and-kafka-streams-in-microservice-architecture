package com.sgenlecroyant.kafka.microservice.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgenlecroyant.kafka.microservice.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, String>{

}
