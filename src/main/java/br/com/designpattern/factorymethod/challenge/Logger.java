package br.com.designpattern.factorymethod.challenge;

public abstract class Logger {

    public void log(String message) {
        createLogger().print(message);
    }

    protected abstract LogPrinter createLogger();

}
