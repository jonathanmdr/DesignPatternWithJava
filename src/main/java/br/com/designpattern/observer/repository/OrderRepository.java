package br.com.designpattern.observer.repository;

import br.com.designpattern.observer.model.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> getAll();

}
