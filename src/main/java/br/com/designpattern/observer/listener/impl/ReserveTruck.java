package br.com.designpattern.observer.listener.impl;

import br.com.designpattern.observer.listener.Listener;
import br.com.designpattern.observer.notifier.Notifier;

public class ReserveTruck implements Listener {

    private final Notifier notifier;

    public ReserveTruck(Notifier notifier) {
        this.notifier = notifier;
        this.notifier.subscribe(this);
    }

    @Override
    public void execute() {
        this.notifier.getOrders().forEach(
                order -> System.out.println(String.format("Reserve truck to Order: %s", order.getDescription()))
        );
    }

}
