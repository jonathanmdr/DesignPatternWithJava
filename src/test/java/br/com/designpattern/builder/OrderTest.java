package br.com.designpattern.builder;

import br.com.designpattern.builder.builder.OrderBuilder;
import br.com.designpattern.builder.model.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTest {

    @Test
    public void shouldBeCalculateTotalOrderToVipCustomer() {
        Order order = new OrderBuilder()
                .withVipCustomer("Jonathan Henrique")
                .withOrderItem("Smartphone", 1, 1000)
                .withOrderItem("Kindle", 1, 300)
                .build();

        BigDecimal actual = order.getTotal();

        assertNotNull(order.getId());
        assertEquals(new BigDecimal(1248).doubleValue(), actual.doubleValue(), 0.0001);
    }

    @Test
    public void shouldBeCalculateTotalOrderToCustomer() {
        Order order = new OrderBuilder()
                .withCustomer("Jonathan Henrique")
                .withOrderItem("Smartphone", 1, 1000)
                .withOrderItem("Kindle", 1, 300)
                .build();

        BigDecimal actual = order.getTotal();

        assertNotNull(order.getId());
        assertEquals(new BigDecimal(1300).doubleValue(), actual.doubleValue(), 0.0001);
    }

}
