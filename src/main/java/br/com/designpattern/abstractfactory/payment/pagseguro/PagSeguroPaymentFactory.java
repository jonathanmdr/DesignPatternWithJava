package br.com.designpattern.abstractfactory.payment.pagseguro;

import br.com.designpattern.abstractfactory.operator.Operator;
import br.com.designpattern.abstractfactory.operator.cielo.Cielo;
import br.com.designpattern.abstractfactory.payment.PaymentFactory;
import br.com.designpattern.abstractfactory.riskmanager.RiskManager;
import br.com.designpattern.abstractfactory.riskmanager.fcontrol.FControl;

public class PagSeguroPaymentFactory implements PaymentFactory {

    @Override
    public Operator getOperatorInstance() {
        return new Cielo();
    }

    @Override
    public RiskManager createRiskManagerInstance() {
        return new FControl();
    }

}
