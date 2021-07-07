package br.com.designpattern.factorymethod.directmail.impl;

import br.com.designpattern.factorymethod.directmail.DirectMail;
import br.com.designpattern.factorymethod.repository.ContactRepository;
import br.com.designpattern.factorymethod.repository.impl.ContactCsvRepository;

public class DirectMailCsv extends DirectMail {

    private final String fileName;

    public DirectMailCsv(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected ContactRepository contactRepository() {
        return new ContactCsvRepository(fileName);
    }

}
