package br.com.designpattern.observer.notifier;

import br.com.designpattern.observer.listener.Listener;
import br.com.designpattern.observer.model.Order;

import java.util.List;

public interface Notifier {

    void subscribe(Listener listener);
    void unsubscribe(Listener listener);
    void notifyAllListeners();
    void newOrders(List<Order> orders);
    List<Order> getOrders();

}
