package br.com.designpattern.builder.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(this::calculateWithDiscountRule)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private BigDecimal calculateWithDiscountRule(OrderItem orderItem) {
        BigDecimal total = new BigDecimal(orderItem.getAmount())
                .multiply(orderItem.getValue());

        if (customer.isVip())
            return total.multiply(new BigDecimal(0.96));

        return total;
    }

}
