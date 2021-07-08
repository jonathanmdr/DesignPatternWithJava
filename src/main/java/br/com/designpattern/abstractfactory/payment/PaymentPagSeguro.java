package br.com.designpattern.abstractfactory.payment;

import br.com.designpattern.abstractfactory.operator.Cielo;
import br.com.designpattern.abstractfactory.operator.TransactionUnauthorizedException;
import br.com.designpattern.abstractfactory.riskmanager.AlertRiskException;
import br.com.designpattern.abstractfactory.riskmanager.FControl;

import java.math.BigDecimal;

public class PaymentPagSeguro {

    private Cielo operator;
    private FControl riskManager;

    public PaymentPagSeguro(Cielo operator, FControl riskManager) {
        this.operator = operator;
        this.riskManager = riskManager;
    }

    public Long authorize(String cardNumber, BigDecimal value) throws TransactionUnauthorizedException, AlertRiskException {
        this.operator.capture(cardNumber, value);
        this.riskManager.assessRisk(cardNumber, value);
        return this.operator.confirm();
    }

}
