package br.com.designpattern.builder.challenge;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NfBuilder {

    private Nf nf;

    public NfBuilder() { }

    public NfBuilder physicalPerson() {
        nf = new NfPf();
        return this;
    }

    public NfBuilder legalPerson() {
        nf = new NfPj();
        return this;
    }

    public NfBuilder number(String number) {
        nf.setNumber(number);
        return this;
    }

    public NfBuilder createdAt(String date) {
        try {
            nf.setCreatedAt(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date value informed to field 'createdAt'");
        }
        return this;
    }

    public NfBuilder withItem(String name, int amount, double value) {
        NfItem item = new NfItem();
        item.setName(name);
        item.setAmount(amount);
        item.setValue(new BigDecimal(value));

        if (nf.getItems() == null) {
            nf.setItems(new ArrayList<>());
        }

        nf.getItems().add(item);

        return this;
    }

    public Nf build() {
        return nf;
    }

}
