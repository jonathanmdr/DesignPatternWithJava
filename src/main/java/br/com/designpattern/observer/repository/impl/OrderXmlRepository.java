package br.com.designpattern.observer.repository.impl;

import br.com.designpattern.observer.model.Order;
import br.com.designpattern.observer.repository.OrderRepository;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

public class OrderXmlRepository implements OrderRepository {

    private final String fileName;

    public OrderXmlRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Order> getAll() {
        XStream xstream = new XStream();
        xstream.alias("orders", List.class);
        xstream.alias("order", Order.class);

        URL file = this.getClass().getResource("/" + fileName);
        return (List<Order>) xstream.fromXML(file);
    }

}
