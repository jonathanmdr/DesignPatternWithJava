package br.com.designpattern.factorymethod.challenge;

public class Main {

    public static void main(String[] args) {
        Logger logger = new ConsoleLogCreator();
        logger.log("Hello world!");
    }

}
