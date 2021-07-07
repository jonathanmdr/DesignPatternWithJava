package br.com.designpattern.builder.builder;

import br.com.designpattern.builder.model.Customer;
import br.com.designpattern.builder.model.Order;
import br.com.designpattern.builder.model.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class OrderBuilder {

    private Order order;

    public OrderBuilder() {
        this.order = new Order();
    }

    public OrderBuilder withVipCustomer(String customerName) {
        order.setCustomer(definingCustomer(customerName, true));
        return this;
    }

    public OrderBuilder withCustomer(String customerName) {
        order.setCustomer(definingCustomer(customerName, false));
        return this;
    }

    public OrderBuilder withOrderItem(String itemName, Integer amount, double value) {
        OrderItem orderItem = new OrderItem();
        orderItem.setName(itemName);
        orderItem.setAmount(amount);
        orderItem.setValue(new BigDecimal(value));

        if (order.getItems() == null) {
            order.setItems(new ArrayList<>());
        }

        order.getItems().add(orderItem);

        return this;
    }

    public Order build() {
        order.setId(UUID.randomUUID().toString());
        return order;
    }

    private Customer definingCustomer(String customerName, boolean isVip) {
        Customer customer = new Customer();
        customer.setName(customerName);
        customer.setVip(isVip);
        return customer;
    }

}
