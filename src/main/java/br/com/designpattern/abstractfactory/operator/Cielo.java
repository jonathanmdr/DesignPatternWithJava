package br.com.designpattern.abstractfactory.operator;

import java.math.BigDecimal;

public class Cielo {

    private Long confirmationCode = -1L;

    public void capture(String cardNumber, BigDecimal value) throws TransactionUnauthorizedException {
        if (cardNumber.startsWith("5555")) {
            throw new TransactionUnauthorizedException("Invalid card number");
        }

        this.confirmationCode = (long) Math.random() * 1000;
    }

    public Long confirm() {
        System.out.println("Debiting the customer's account by cielo");
        return this.confirmationCode;
    }

}
