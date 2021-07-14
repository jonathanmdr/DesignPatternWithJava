package br.com.designpattern.observer.notifier.impl;

import br.com.designpattern.observer.listener.Listener;
import br.com.designpattern.observer.model.Order;
import br.com.designpattern.observer.notifier.Notifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderNotifier implements Notifier {

    private final Set<Listener> listeners;
    private List<Order> orders;

    public OrderNotifier() {
        this.listeners = new HashSet<>();
    }

    @Override
    public void subscribe(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void unsubscribe(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void notifyAllListeners() {
        this.listeners.forEach(listener -> listener.execute());
    }

    @Override
    public void newOrders(List<Order> orders) {
        this.orders = orders;
        this.notifyAllListeners();
    }

    @Override
    public List<Order> getOrders() {
        return this.orders;
    }

}
