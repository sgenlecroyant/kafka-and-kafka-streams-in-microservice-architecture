package com.sgenlecroyant.kafka.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgenlecroyant.kafka.microservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

}
