package br.com.designpattern.factorymethod.challenge;

public class ConsoleLogCreator extends Logger {

    @Override
    protected LogPrinter createLogger() {
        return new ConsoleLogPrinter();
    }

}
