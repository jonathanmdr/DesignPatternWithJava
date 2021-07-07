package br.com.designpattern.factorymethod.directmail.impl;

import br.com.designpattern.factorymethod.directmail.DirectMail;
import br.com.designpattern.factorymethod.repository.ContactRepository;
import br.com.designpattern.factorymethod.repository.impl.ContactXmlRepository;

public class DirectMailXml extends DirectMail {

    private final String fileName;

    public DirectMailXml(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected ContactRepository contactRepository() {
        return new ContactXmlRepository(fileName);
    }

}
