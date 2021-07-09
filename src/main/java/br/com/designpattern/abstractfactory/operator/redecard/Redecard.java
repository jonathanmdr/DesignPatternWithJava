package br.com.designpattern.abstractfactory.operator.redecard;

import br.com.designpattern.abstractfactory.operator.Operator;
import br.com.designpattern.abstractfactory.operator.TransactionUnauthorizedException;

import java.math.BigDecimal;

public class Redecard implements Operator {

    private Long confirmationCode = -1L;

    @Override
    public void capture(String cardNumber, BigDecimal value) throws TransactionUnauthorizedException {
        if (cardNumber.startsWith("2222") && valueExceedLimit(value)) {
            throw new TransactionUnauthorizedException("This value exceeds the limit to informed card");
        }

        this.confirmationCode = (long) Math.random() * 300;
    }

    @Override
    public Long confirm() {
        System.out.println("Debiting the customer's account by Redecard");
        return this.confirmationCode;
    }

    private boolean valueExceedLimit(BigDecimal value) {
        BigDecimal limit = new BigDecimal("1000");
        return value.compareTo(limit) > 0;
    }

}
