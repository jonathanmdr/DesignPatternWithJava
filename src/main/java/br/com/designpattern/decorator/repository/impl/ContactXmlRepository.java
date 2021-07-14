package br.com.designpattern.decorator.repository.impl;

import br.com.designpattern.decorator.model.Contact;
import br.com.designpattern.decorator.repository.ContactRepository;
import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactXmlRepository implements ContactRepository {

    private static XStream xStream;
    private final String fileName;

    public ContactXmlRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void insert(Contact contact) {
        List<Contact> contacts = getAllContacts();
        contacts.add(contact);
        writeContactsToXmlFile(contacts);
    }

    @Override
    public Contact findById(int id) {
        System.out.printf("Find contact with id %s on XML file%n", id);
        return getAllContacts().stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Contact with id %s not found", id)));
    }

    private void writeContactsToXmlFile(List<Contact> contacts) {
        try {
            OutputStream outputStream = new FileOutputStream(fileName);
            getXStream().toXML(contacts, outputStream);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Save file presenting error", ex);
        }
    }

    private List<Contact> getAllContacts() {
        Path path = Paths.get("./", fileName);

        try {
            return (List<Contact>) getXStream().fromXML(path.toFile());
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    private XStream getXStream() {
        if (Objects.nonNull(xStream)) {
            return xStream;
        }

        xStream = new XStream();
        xStream.alias("contacts", List.class);
        xStream.alias("contact", Contact.class);

        return xStream;
    }

}
