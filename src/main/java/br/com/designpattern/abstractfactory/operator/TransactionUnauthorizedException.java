package br.com.designpattern.abstractfactory.operator;

public class TransactionUnauthorizedException extends RuntimeException {
    public TransactionUnauthorizedException(String message) {
        super(message);
    }
}
