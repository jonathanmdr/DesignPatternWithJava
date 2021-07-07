package br.com.designpattern.factorymethod;

import br.com.designpattern.factorymethod.directmail.DirectMail;
import br.com.designpattern.factorymethod.directmail.impl.DirectMailCsv;

import javax.swing.JOptionPane;

public class CustomerRelationship {

    public static void main(String[] args) {
        DirectMail directMail = new DirectMailCsv("contatos.csv");
        String message = JOptionPane.showInputDialog("Inform the mail message:");
        boolean status = directMail.sendMail(message);
        JOptionPane.showMessageDialog(null, "Status send mails: " + status);
    }

}
