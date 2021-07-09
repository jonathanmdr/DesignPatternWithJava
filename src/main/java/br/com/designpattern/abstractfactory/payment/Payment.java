package br.com.designpattern.abstractfactory.payment;

import br.com.designpattern.abstractfactory.operator.Operator;
import br.com.designpattern.abstractfactory.operator.TransactionUnauthorizedException;
import br.com.designpattern.abstractfactory.riskmanager.AlertRiskException;
import br.com.designpattern.abstractfactory.riskmanager.RiskManager;

import java.math.BigDecimal;

public class Payment {

    private Operator operator;
    private RiskManager riskManager;

    public Payment(PaymentFactory paymentFactory) {
        this.operator = paymentFactory.getOperatorInstance();
        this.riskManager = paymentFactory.createRiskManagerInstance();
    }

    public Long authorize(String cardNumber, BigDecimal value) throws TransactionUnauthorizedException, AlertRiskException {
        this.operator.capture(cardNumber, value);
        this.riskManager.assessRisk(cardNumber, value);
        return this.operator.confirm();
    }

}
