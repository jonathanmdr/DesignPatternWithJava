package br.com.designpattern.abstractfactory.challenge.bankslip;

public class HsbcBankSlip implements BankSlip {

    @Override
    public void generate() {
        System.out.println("Generating bank slip by HSBC");
    }

}
