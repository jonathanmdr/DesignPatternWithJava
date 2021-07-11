package br.com.designpattern.abstractfactory.challenge.sell;

import br.com.designpattern.abstractfactory.challenge.bankslip.BankSlip;
import br.com.designpattern.abstractfactory.challenge.nfe.NFe;

public class Sell {

    private final NFe nFe;
    private final BankSlip bankSlip;

    public Sell(SellFactory sellFactory) {
        this.nFe = sellFactory.getNFeInstance();
        this.bankSlip = sellFactory.getBankSlipInstance();
    }

    public void generate() {
        System.out.println("Sell generate called");
        nFe.generate();
        bankSlip.generate();
        System.out.println("Sell finish");
    }

}
