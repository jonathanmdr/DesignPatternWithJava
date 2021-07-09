package br.com.designpattern.abstractfactory.payment;

import br.com.designpattern.abstractfactory.operator.Operator;
import br.com.designpattern.abstractfactory.riskmanager.RiskManager;

public interface PaymentFactory {

    Operator getOperatorInstance();
    RiskManager createRiskManagerInstance();

}
