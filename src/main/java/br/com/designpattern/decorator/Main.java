package br.com.designpattern.decorator;

import br.com.designpattern.decorator.model.Contact;
import br.com.designpattern.decorator.repository.ContactRepository;
import br.com.designpattern.decorator.repository.impl.ContactXmlCacheRepository;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Contact c1 = new Contact(1, "jonathan", "99999");
        Contact c2 = new Contact(2, "jonathan henrique", "8888888");

        ContactRepository repository = new ContactXmlCacheRepository("contacts.xml");

        repository.insert(c1);
        repository.insert(c2);

        Contact contact = repository.findById(1);

        System.out.println(contact);

        Contact contact2 = repository.findById(1);

        System.out.println(contact2);
    }

}
