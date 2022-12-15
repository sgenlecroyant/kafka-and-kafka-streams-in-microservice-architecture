package com.sgenlecroyant.kafka.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgenlecroyant.kafka.microservice.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, String> {

}
