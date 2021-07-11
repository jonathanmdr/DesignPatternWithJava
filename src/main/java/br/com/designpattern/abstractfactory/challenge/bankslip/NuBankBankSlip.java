package br.com.designpattern.abstractfactory.challenge.bankslip;

public class NuBankBankSlip implements BankSlip {

    @Override
    public void generate() {
        System.out.println("Generating bank slip by NuBank");
    }

}
