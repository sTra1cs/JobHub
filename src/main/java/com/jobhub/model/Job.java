package com.jobhub.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Job {
    private Long orderNumber;
    private String description;
    private LocalDate datePosted;
    private BigDecimal price;

    public Job(Long orderNumber, String description,LocalDate datePosted,BigDecimal price){
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
