package br.com.designpattern.abstractfactory.riskmanager;

import java.math.BigDecimal;

public class FControl {
    public void assessRisk(String cardNumber, BigDecimal value) throws AlertRiskException {
        if (cardNumber.startsWith("7777")) {
            throw new AlertRiskException("Unknown card with number");
        }
    }
}
