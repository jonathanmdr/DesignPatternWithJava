package br.com.designpattern.abstractfactory.challenge.sell;

import br.com.designpattern.abstractfactory.challenge.bankslip.BankSlip;
import br.com.designpattern.abstractfactory.challenge.nfe.NFe;

import java.io.IOException;
import java.util.Properties;

public class SellFactoryConfiguration implements SellFactory {

    private static Properties properties;

    @Override
    public NFe getNFeInstance() {
        try {
            String implClass = getProperties().getProperty("nfe");
            return (NFe) Class.forName(implClass).getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Failed to get a NF-e instance class");
        }
    }

    @Override
    public BankSlip getBankSlipInstance() {
        try {
            String implClass = getProperties().getProperty("bank-slip");
            return (BankSlip) Class.forName(implClass).getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Failed to get a bank slip instance class");
        }
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(this.getClass().getResourceAsStream("/config.properties"));
            } catch (IOException e) {
                throw new IllegalStateException("Properties configuration not found");
            }
        }

        return properties;
    }

}
