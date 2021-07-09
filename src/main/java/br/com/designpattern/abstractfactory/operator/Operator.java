package br.com.designpattern.abstractfactory.operator;

import java.math.BigDecimal;

public interface Operator {

    void capture(String cardNumber, BigDecimal value) throws TransactionUnauthorizedException;
    Long confirm();

}
