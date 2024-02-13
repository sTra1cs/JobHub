package com.jobhub.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private Long orderNumber;
    private String description;
    private LocalDate datePosted;
    private int price;

    public Order(Long orderNumber, String description, LocalDate datePosted, int price){
        this.orderNumber = orderNumber;
        this.description = description;
        this.datePosted = datePosted;
        this.price = price;
    }


    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
