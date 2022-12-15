package com.sgenlecroyant.kafka.microservice.broker.order.message;

public class DiscountMessage {

    private String discountCode;
    private Integer percentage;

    public DiscountMessage(String discountCode, Integer percentage){
    	this.discountCode = discountCode;
    	this.percentage = percentage;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public Integer getPercentage() {
        return percentage;
    }
}

