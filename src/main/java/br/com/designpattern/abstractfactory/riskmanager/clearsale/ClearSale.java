package br.com.designpattern.abstractfactory.riskmanager.clearsale;

import br.com.designpattern.abstractfactory.riskmanager.AlertRiskException;
import br.com.designpattern.abstractfactory.riskmanager.RiskManager;

import java.math.BigDecimal;

public class ClearSale implements RiskManager {

    @Override
    public void assessRisk(String cardNumber, BigDecimal value) throws AlertRiskException {
        if (cardNumber.startsWith("1111") && veryHighValue(value)) {
            throw new AlertRiskException("This value is very high to card");
        }
    }

    private boolean veryHighValue(BigDecimal value) {
        BigDecimal limit = new BigDecimal("5000");
        return limit.compareTo(value) < 0;
    }

}
