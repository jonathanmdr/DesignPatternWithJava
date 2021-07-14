package br.com.designpattern.observer.listener.impl;

import br.com.designpattern.observer.listener.Listener;
import br.com.designpattern.observer.notifier.Notifier;

public class BillingOrder implements Listener {

    private final Notifier notifier;

    public BillingOrder(Notifier notifier) {
        this.notifier = notifier;
        this.notifier.subscribe(this);
    }

    @Override
    public void execute() {
        this.notifier.getOrders().forEach(
                order -> System.out.println(String.format("Billing to Order: %s | Value: %s", order.getDescription(), order.getValue()))
        );
    }

}
