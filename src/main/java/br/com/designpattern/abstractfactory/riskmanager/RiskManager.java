package br.com.designpattern.abstractfactory.riskmanager;

import java.math.BigDecimal;

public interface RiskManager {

    void assessRisk(String cardNumber, BigDecimal value) throws AlertRiskException;

}
