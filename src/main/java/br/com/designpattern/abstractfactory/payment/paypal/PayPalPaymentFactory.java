package br.com.designpattern.abstractfactory.payment.paypal;

import br.com.designpattern.abstractfactory.operator.Operator;
import br.com.designpattern.abstractfactory.operator.redecard.Redecard;
import br.com.designpattern.abstractfactory.payment.PaymentFactory;
import br.com.designpattern.abstractfactory.riskmanager.RiskManager;
import br.com.designpattern.abstractfactory.riskmanager.clearsale.ClearSale;

public class PayPalPaymentFactory implements PaymentFactory {

    @Override
    public Operator getOperatorInstance() {
        return new Redecard();
    }

    @Override
    public RiskManager createRiskManagerInstance() {
        return new ClearSale();
    }

}
