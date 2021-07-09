package br.com.designpattern.abstractfactory.operator.cielo;

import br.com.designpattern.abstractfactory.operator.Operator;
import br.com.designpattern.abstractfactory.operator.TransactionUnauthorizedException;

import java.math.BigDecimal;

public class Cielo implements Operator {

    private Long confirmationCode = -1L;

    @Override
    public void capture(String cardNumber, BigDecimal value) throws TransactionUnauthorizedException {
        if (cardNumber.startsWith("5555")) {
            throw new TransactionUnauthorizedException("Invalid card number");
        }

        this.confirmationCode = (long) Math.random() * 1000;
    }

    @Override
    public Long confirm() {
        System.out.println("Debiting the customer's account by Cielo");
        return this.confirmationCode;
    }

}
