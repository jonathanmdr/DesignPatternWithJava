package br.com.designpattern.proxy;

import br.com.designpattern.proxy.model.Contact;
import br.com.designpattern.proxy.repository.ContactRepository;
import br.com.designpattern.proxy.repository.impl.ContactBlackListFilter;
import br.com.designpattern.proxy.repository.impl.ContactXmlRepository;

import javax.swing.*;
import java.util.List;

public class SendEmailMandrill {

    public static void main(String[] args) {
        ContactRepository contactRepositoryFilter = new ContactBlackListFilter(
                "contatos-black-list.xml",
                new ContactXmlRepository("contatos.xml")
        );
        String message = JOptionPane.showInputDialog("Inform the mail message:");
        boolean status = sendMail(message, contactRepositoryFilter.getAll());
        JOptionPane.showMessageDialog(null, "Status send mails: " + status);
    }

    private static boolean sendMail(String message, List<Contact> contacts) {
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

}
