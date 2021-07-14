package br.com.designpattern.observer.model;

import java.math.BigDecimal;

public class Order {

    private String description;
    private BigDecimal value;

    public Order() { }

    public Order(String description, BigDecimal value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
