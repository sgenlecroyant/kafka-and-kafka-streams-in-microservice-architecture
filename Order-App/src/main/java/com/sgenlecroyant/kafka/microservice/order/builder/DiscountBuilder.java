package com.sgenlecroyant.kafka.microservice.order.builder;

import com.sgenlecroyant.kafka.microservice.api.server.request.DiscountRequest;
import com.sgenlecroyant.kafka.microservice.entity.Discount;

public class DiscountBuilder {

    private String discountCode;
    private Integer percentage;

    public DiscountBuilder(DiscountRequest discountRequest){
        this.discountCode = discountRequest.getDiscountCode();
        this.percentage = discountRequest.getPercentage();
    }

    public Integer getPercentage() {
        return percentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public DiscountBuilder code(String discountCode){
        this.discountCode = discountCode;
        return this;
    }

    public DiscountBuilder percentage(Integer percentage){
        this.percentage = percentage;
        return this;
    }

    public Discount build(){
        return new Discount(this);
    }
}
