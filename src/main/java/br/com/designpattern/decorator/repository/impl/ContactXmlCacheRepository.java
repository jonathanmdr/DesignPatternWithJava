package br.com.designpattern.decorator.repository.impl;

import br.com.designpattern.decorator.model.Contact;
import br.com.designpattern.decorator.repository.ContactRepository;

import java.util.HashMap;
import java.util.Map;

public class ContactXmlCacheRepository extends ContactXmlRepository implements ContactRepository {

    private static Map<Integer, Contact> cache;

    public ContactXmlCacheRepository(String fileName) {
        super(fileName);
        cache = new HashMap<>();
    }

    @Override
    public void insert(Contact contact) {
        super.insert(contact);
    }

    @Override
    public Contact findById(int id) {
        if (cache.containsKey(id)) {
            System.out.printf("Find contact with id %s on cache%n", id);
            return cache.get(id);
        }

        Contact contact = super.findById(id);
        cache.put(id, contact);

        return contact;
    }

}
