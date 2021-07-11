package br.com.designpattern.abstractfactory.challenge.sell;

import br.com.designpattern.abstractfactory.challenge.bankslip.BankSlip;
import br.com.designpattern.abstractfactory.challenge.nfe.NFe;

public interface SellFactory {

    NFe getNFeInstance();
    BankSlip getBankSlipInstance();

}
