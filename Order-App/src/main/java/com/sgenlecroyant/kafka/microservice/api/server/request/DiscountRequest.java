package com.sgenlecroyant.kafka.microservice.api.server.request;

public class DiscountRequest {

    private String discountCode;
    private Integer percentage;

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
