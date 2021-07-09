package br.com.designpattern.abstractfactory.riskmanager.fcontrol;

import br.com.designpattern.abstractfactory.riskmanager.AlertRiskException;
import br.com.designpattern.abstractfactory.riskmanager.RiskManager;

import java.math.BigDecimal;

public class FControl implements RiskManager {

    @Override
    public void assessRisk(String cardNumber, BigDecimal value) throws AlertRiskException {
        if (cardNumber.startsWith("7777")) {
            throw new AlertRiskException("Unknown card with number");
        }
    }

}
