package com.sgenlecroyant.kafka.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgenlecroyant.kafka.microservice.entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, String>{

}
