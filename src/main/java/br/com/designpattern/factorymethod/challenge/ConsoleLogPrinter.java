package br.com.designpattern.factorymethod.challenge;

import java.time.LocalDateTime;

public class ConsoleLogPrinter implements LogPrinter {

    @Override
    public void print(String message) {
        System.out.println(LocalDateTime.now() + ": " + message);
    }

}
