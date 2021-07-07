package br.com.designpattern.factorymethod;

import br.com.designpattern.factorymethod.directmail.DirectMail;
import br.com.designpattern.factorymethod.directmail.impl.DirectMailXml;

import javax.swing.*;

public class CustomerOtherContact {

    public static void main(String[] args) {
        DirectMail directMail = new DirectMailXml("contatos.xml");
        String message = JOptionPane.showInputDialog("Inform the mail message:");
        boolean status = directMail.sendMail(message);
        JOptionPane.showMessageDialog(null, "Status send mails: " + status);
    }

}
