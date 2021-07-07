package br.com.designpattern.factorymethod.directmail;

import br.com.designpattern.factorymethod.contact.Contact;
import br.com.designpattern.factorymethod.repository.ContactRepository;

import java.util.List;

public abstract class DirectMail {

    public boolean sendMail(String message) {
        List<Contact> contacts = contactRepository().getAll();

        System.out.println("Connecting SMTP server...");
        System.out.println("Message to send: ".concat(message));
        System.out.println();

        contacts.forEach(contact -> {
            System.out.println("From: <contact@mail.com>");
            System.out.printf("To: [%s] <%s>\n", contact.getName(), contact.getMail());
            System.out.println(message);
            System.out.println();
        });

        return true;
    }

    protected abstract ContactRepository contactRepository();

}
