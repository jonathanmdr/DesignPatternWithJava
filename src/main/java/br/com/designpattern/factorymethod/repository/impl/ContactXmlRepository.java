package br.com.designpattern.factorymethod.repository.impl;

import br.com.designpattern.factorymethod.contact.Contact;
import br.com.designpattern.factorymethod.repository.ContactRepository;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

public class ContactXmlRepository implements ContactRepository {

    private final String fileName;

    public ContactXmlRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Contact> getAll() {
        XStream xstream = new XStream();
        xstream.alias("contacts", List.class);
        xstream.alias("contact", Contact.class);

        URL file = this.getClass().getResource("/" + fileName);
        return (List<Contact>) xstream.fromXML(file);
    }

}
