package br.com.designpattern.abstractfactory.challenge;

import br.com.designpattern.abstractfactory.challenge.sell.Sell;
import br.com.designpattern.abstractfactory.challenge.sell.SellFactoryConfiguration;

public class Main {

    public static void main(String[] args) {
        Sell sell = new Sell(new SellFactoryConfiguration());
        sell.generate();
    }

}
